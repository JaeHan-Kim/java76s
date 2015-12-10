package java76.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.MembersDao;
import java76.pms.domain.Users;
import java76.pms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/members/*")
public class MembersController {
	public static String SAVED_DIR = "/file";
	@Autowired MembersDao membersDao;
	@Autowired ServletContext servletContext;
	
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
    
		List<Users> members = membersDao.selectList(paramMap);

		request.setAttribute("members", members);
		return "members/MembersList";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form(){
		return "members/MembersForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Users members, MultipartFile photofile) throws Exception {

		/*if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename()); // 파일 이름 
			File attachfile = new File(
					servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFileName);
			photofile.transferTo(attachfile);
			makeThumbnailImage(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName,
					servletContext.getRealPath(SAVED_DIR) +"/s-"+newFileName + ".png");
			members.setPhoto(newFileName);
		}
		*/
	
		membersDao.insert(members);
	  
	  System.out.println(members.toString());

		return "redirect:../auth/login.do";
	}

	@RequestMapping("detail")
	public String detail(
			String email,
			HttpServletRequest request) throws Exception {

		Users members = membersDao.selectOne(email);
		request.setAttribute("members", members);

		return "members/MembersDetail";

	}
	@RequestMapping("update")
	public String update(
			Users student,
			MultipartFile photofile,
			String photo,
			HttpServletRequest request) throws Exception {


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
			student.setPhoto(newFileName);
		} else if (student.getPhoto().length() == 0) {
			student.setPhoto(null);
		}

		if (membersDao.update(student) <= 0){
			request.setAttribute("errorCode", "401");
			return "members/MembersAuthError";
		}
		return "redirect:list.do";
	}
	@RequestMapping("delete")
	public String delete(
			String email,
			Model model) throws Exception {

		if (membersDao.delete(email) <= 0) { 
			model.addAttribute("errorCode", "401");
			return "members/MembersAuthError";
		}
		return "redirect:list.do";
	}
	
	@RequestMapping(value="join", method=RequestMethod.GET)
  public String joinform() {
    return "/members/JoinForm";
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