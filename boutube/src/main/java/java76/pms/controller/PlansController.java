package java76.pms.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.PlansDao;
import java76.pms.domain.Users;
import java76.pms.domain.Contents;
import java76.pms.util.MultipartHelper;


@Controller
@RequestMapping("/plans/*")
public class PlansController {
	public static String SAVED_DIR = "/attachFile";
	
	@Autowired PlansDao plansDao;
	@Autowired ServletContext servletContext;
	
	@RequestMapping("list")
	public String list(
			HttpSession session,
			@RequestParam(defaultValue = "1")int pageNo, 
			@RequestParam(defaultValue = "10")int pageSize,
			@RequestParam(defaultValue = "no")String keyword,
			@RequestParam(defaultValue = "desc")String align,
				HttpServletRequest request) throws Exception {

		Users member = (Users)session.getAttribute("loginUser");
		HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);
    paramMap.put("no", member.getNo());
    
		List<Contents> plans = plansDao.selectList(paramMap);

		request.setAttribute("plans", plans);
		
		return "plans/PlansList";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form(){
		return "plans/PlansForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(HttpSession session,
			Contents plans, MultipartFile file) throws Exception {
		
		if (file.getSize() >0) {
			String newFilename = MultipartHelper.generateFilename(file.getOriginalFilename()); // 파일 이름 
			File newFile = new File( servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFilename);
			file.transferTo(newFile);
			plans.setAttachFile(newFilename);
		}
		Users member = (Users)session.getAttribute("loginUser");
		plans.setNo(member.getNo());
		System.out.println(member.getNo());
		plansDao.insert(plans);

		return "redirect:list.do";
	}

	@RequestMapping("detail")
	public String detail(int no, Model model) throws Exception {

		Contents plans = plansDao.selectOne(no);
		model.addAttribute("plan", plans);    
		return "plans/PlansDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
			Contents plans,
			MultipartFile file, 
			Model model) throws Exception { 
		
		
		if (file.getSize() > 0) {
			String newFilename = MultipartHelper.generateFilename(file.getOriginalFilename()); // 파일 이름 
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
				                     	+ "/" + newFilename);
			file.transferTo(attachfile);
			plans.setAttachFile(newFilename);
		}	else if (plans.getAttachFile().length() == 0) {
			plans.setAttachFile(null);
		}

		if (plansDao.update(plans) <= 0) {
			model.addAttribute("errorCode","401");
			return "plans/PlansAuthError";
		} 
		
		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(
			int no,
			String password,
			Model model) throws Exception {
		
		HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    paramMap.put("password", password);
    
		if (plansDao.delete(paramMap) <= 0) {
			model.addAttribute("errorCode", "401");
			return "plans/PlansAuthError";
		} 

		return "redirect:list.do";
	}
}