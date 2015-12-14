package java76.pms.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

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

import java76.pms.dao.ContentsDao;
import java76.pms.domain.Contents;
import java76.pms.domain.Users;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/contents/*")
public class ContentsController {
	private static final Logger log = Logger.getLogger(ContentsController.class);
	public static String SAVED_DIR = "/video";

	@Autowired ContentsDao contentsDao;
	@Autowired ServletContext servletContext;
	//	@RequestMapping(value="main.do", method=RequestMethod.GET)
	//	public String mainform() {
	//		return "contents/ContentsMain";
	//	}
	@RequestMapping("main")
	public String list(
			HttpSession session,
			@RequestParam(defaultValue = "1")int pageNo, 
			@RequestParam(defaultValue = "4")int pageSize,
			HttpServletRequest request) throws Exception {
		log.debug("list 호출");
		Users user = (Users)session.getAttribute("loginUser");
		if (user == null) {
			log.debug("user null");
		}
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("length", pageSize);

		List<Contents> allContents = contentsDao.paging();
		int cnt = 0;
		for(Contents contmp : allContents) {
			cnt++;
		}

		cnt = (int)Math.ceil(cnt / 4.0);

		request.setAttribute("cnt", cnt);

		int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 

		request.setAttribute("temp", temp);


		List<Contents> contents = contentsDao.selectList(paramMap);

		request.setAttribute("contents", contents);

		return "contents/ContentsMain";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form(){
		return "contents/ContentsForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			HttpSession session,
			Contents contents,
			MultipartFile videofile) throws Exception{
		Users user = (Users)session.getAttribute("loginUser");
		log.debug(contents.getTitle());
		log.debug(contents.getContent());
		log.debug(user.getUno());
		contents.setContents_uno(user.getUno());
		if (videofile.getSize() >0) {
			String newFilename = MultipartHelper.generateFilename(videofile.getOriginalFilename()); // 파일 이름 
			File newFile = new File( servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFilename);
			videofile.transferTo(newFile);
			contents.setVideo(newFilename);
		}
		contentsDao.insert(contents);
		return "redirect:../contents/main.do";
	}

	@RequestMapping("detail")
	public String detail(int cno, Model model) throws Exception {
		Contents contents = null;

		contentsDao.addViews(cno);
		model.addAttribute("contents", contents);

		contents = contentsDao.selectOne(cno);
		model.addAttribute("contents", contents);    
		return "contents/ContentsDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
			Contents plans,
			MultipartFile file, 
			Model model) throws Exception { 
		System.out.println("update 실행");

		if (file.getSize() > 0) {
			String newFilename = MultipartHelper.generateFilename(file.getOriginalFilename()); // 파일 이름 
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFilename);
			file.transferTo(attachfile);
			plans.setVideo(newFilename);
		}	else if (plans.getVideo().length() == 0) {
			plans.setVideo(null);
		}

		if (contentsDao.update(plans) <= 0) {
			model.addAttribute("errorCode","401");
			return "contents/ContentsAuthError";
		} 

		return "redirect:../contents/main.do";
	}

	@RequestMapping("delete")
	public String delete(
			int uno,
			int auth,
			Model model) throws Exception {

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("uno", uno);
		paramMap.put("auth", auth);

		if (contentsDao.delete(paramMap) <= 0) {
			model.addAttribute("errorCode", "401");
			return "contents/ContentsAuthError";
		} 

		return "redirect:list.do";
	}
}