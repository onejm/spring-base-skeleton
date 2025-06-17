package com.mySpring.myapp.adminPage.admin.controller;

import com.mySpring.myapp.adminPage.admin.service.AdminService;
import com.mySpring.myapp.adminPage.admin.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("adminController")
//@EnableAspectJAutoProxy
public class AdminControllerImpl implements AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	AdminVO adminVO;
	
	@RequestMapping(value = {"/adminPage/main.do"}, method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");	
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override 
	@RequestMapping(value="/adminPage/admin/listAdmins.do" ,method = RequestMethod.GET)
	public ModelAndView listAdmins(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("listviewName: " + viewName);
		List adminsList = adminService.listAdmins();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("adminsList", adminsList);
		return mav;
	}

	@Override
	@RequestMapping(value="/adminPage/admin/addAdmin.do" ,method = RequestMethod.POST)
	public ModelAndView addAdmin(@ModelAttribute("admin") AdminVO admin,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("addadmin: " + admin.getPwd());
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = adminService.addAdmin(admin);
		System.out.println("result : " + result);
		ModelAndView mav = new ModelAndView("redirect:/adminPage/admin/listAdmins.do");
		return mav;
	} 
	
	@Override
	@RequestMapping(value="/adminPage/admin/removeAdmin.do" ,method = RequestMethod.GET)
	public ModelAndView removeAdmin(@RequestParam("id") String id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
//		String admin_id = request.getParameter("id");
		adminService.removeAdmin(id);
		ModelAndView mav = new ModelAndView("redirect:/adminPage/admin/listAdmins.do");
		return mav;
	}
	/*
	@RequestMapping(value = { "/adminPage/admin/loginForm.do", "/admin/adminForm.do" }, method =  RequestMethod.GET)
	@RequestMapping(value = "/adminPage/admin/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	*/
	
	@Override
	@RequestMapping(value = "/adminPage/admin/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("admin") AdminVO admin,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	adminVO = adminService.login(admin);
	HttpSession session = request.getSession();
	String action1 = (String)session.getAttribute("action");
	System.out.println("loginAction : " + action1);
	if(adminVO != null) {
	    
	    session.setAttribute("admin", adminVO);
	    session.setAttribute("isLogOn", true);
	    //mav.setViewName("redirect:/adminPage/admin/listAdmins.do");
	    String action = (String)session.getAttribute("action");
	    session.removeAttribute("action");
	    if(action!= null) {	
	       mav.setViewName("redirect:"+action);
	    }else {
	       mav.setViewName("redirect:/adminPage/admin/listAdmins.do");
	    }

	}else {
	   rAttr.addAttribute("result","loginFailed");
	   mav.setViewName("redirect:/adminPage/admin/loginForm.do");
	}
	
	return mav;
	}

	@Override
	@RequestMapping(value = "/adminPage/admin/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/adminPage/admin/listAdmins.do");
		return mav;
	}	

	@RequestMapping(value = "/adminPage/admin/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("action : " +  action);
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}


}
