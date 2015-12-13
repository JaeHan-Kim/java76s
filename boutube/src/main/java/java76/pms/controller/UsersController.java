package java76.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.UsersDao;
import java76.pms.domain.Users;
import java76.pms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/users/*")
public class UsersController {
	public static String SAVED_DIR = "/photo";
	@Autowired UsersDao usersDao;
	@Autowired ServletContext servletContext;
	private static final Logger log = Logger.getLogger(ContentsController.class);
	@RequestMapping("list")
	public String list(
			@RequestParam(defaultValue = "1")int pageNo, 
			@RequestParam(defaultValue = "10")int pageSize,
			@RequestParam(defaultValue = "no")String keyword,
			@RequestParam(defaultValue = "desc")String align,
			HttpServletRequest request) throws Exception {

		HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);
    
		List<Users> users = usersDao.selectList(paramMap);

		request.setAttribute("users", users);
		return "users/UsersList";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form(){
		return "users/UsersForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Users users, MultipartFile photofile,
			 Model model) throws Exception {
		log.debug(users.getName());
    String email = users.getEmail();
    String regex = "\\w+@\\w+\\.\\w+";
    String password = users.getPassword();
    String rePassword = users.getRePassword();
    
    boolean emailCheck = Pattern.matches(regex, email);
    
    if (emailCheck == false) {
      model.addAttribute("errorCode", "regex");
      return "users/UsersAuthError";
    } else if (!(password.equals(rePassword))) {
      model.addAttribute("errorCode", "pwd");
      return "users/UsersAuthError";
    }
		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename()); // 파일 이름 
			File attachfile = new File(
					servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFileName);
			photofile.transferTo(attachfile);
			makeThumbnailImage(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName,
					servletContext.getRealPath(SAVED_DIR) +"/s-"+newFileName + ".png");
			users.setPhoto(newFileName);
		}
	
		usersDao.insert(users);
	  
	  log.debug(users.toString());

		return "redirect:../contents/main.do";
	}

	@RequestMapping("detail")
	public String detail(
	    HttpSession session,
			HttpServletRequest request) throws Exception {
		log.debug("detail 호출");
		Users user = (Users)session.getAttribute("loginUser");
		log.debug(user.getUno());
		Users users = usersDao.selectOne(user.getUno());
		request.setAttribute("users", users);

		return "users/UsersDetail";

	}
	@RequestMapping("update")
	public String update(
			Users users,
			MultipartFile photofile,
			String photo,
			HttpServletRequest request) throws Exception {

		log.debug(users.getUno());
		log.debug(users.getEmail());
		log.debug(users.getName());
		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename()); // 파일 이름 
			ServletContext servletContext = request.getServletContext();
			File attachfile = new File(
					request.getServletContext().getRealPath(SAVED_DIR) 
					+ "/" + newFileName);
			photofile.transferTo(attachfile);
			
			makeThumbnailImage(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName,
					servletContext.getRealPath(SAVED_DIR) +"/s-"+newFileName + ".png");
			users.setPhoto(newFileName);
		} else if (users.getPhoto().length() == 0) {
			users.setPhoto(null);
		}

		if (usersDao.update(users) <= 0){
			request.setAttribute("errorCode", "401");
			return "members/MembersAuthError";
		}
		return "redirect:../contents/main.do";
	}
	@RequestMapping("delete")
	public String delete(
			int uno,
			Model model) throws Exception {

		if (usersDao.delete(uno) <= 0) { 
			model.addAttribute("errorCode", "401");
			return "users/UsersAuthError";
		}
		return "redirect:list.do";
	}
	
	@RequestMapping(value="join", method=RequestMethod.GET)
  public String joinform() {
    return "/contents/JoinForm";
  }
	
  private void makeThumbnailImage(String originPath, String thumbPath) 
      throws IOException {
    Thumbnails.of(new File(originPath))
    .size(60,44)
    .outputFormat("png")
    .outputQuality(1.0)
    .toFile(new File(thumbPath));
  }
}