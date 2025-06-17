package com.mySpring.myapp.userPage.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mySpring.myapp.userPage.user.service.UserService;
import com.mySpring.myapp.userPage.user.vo.UserVO;

@Controller("userController")
//@EnableAspectJAutoProxy
public class UserControllerImpl   implements UserController {
	@Autowired
	private UserService userService;
	@Autowired
	UserVO userVO;
	
	@RequestMapping(value = {"/","/main.do"}, method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");	
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override 
	@RequestMapping(value="/user/listUsers.do" ,method = RequestMethod.GET)
	public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("listviewName: " + viewName);
		List usersList = userService.listUsers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("usersList", usersList);
		return mav;
	}

	@Override
	@RequestMapping(value="/user/addUser.do" ,method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") UserVO user,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("adduser: " + user.getPwd());
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = userService.addUser(user);
		System.out.println("result : " + result);
		ModelAndView mav = new ModelAndView("redirect:/user/listUsers.do");
		return mav;
	} 
	
	@Override
	@RequestMapping(value="/user/removeUser.do" ,method = RequestMethod.GET)
	public ModelAndView removeUser(@RequestParam("id") String id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
//		String user_id = request.getParameter("id");
		userService.removeUser(id);
		ModelAndView mav = new ModelAndView("redirect:/user/listUsers.do");
		return mav;
	}
	/*
	@RequestMapping(value = { "/user/loginForm.do", "/user/userForm.do" }, method =  RequestMethod.GET)
	@RequestMapping(value = "/user/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	*/
	
	@Override
	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") UserVO user,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	userVO = userService.login(user);
	HttpSession session = request.getSession();
	String action1 = (String)session.getAttribute("action");
	System.out.println("loginAction : " + action1);
	if(userVO != null) {
	    
	    session.setAttribute("user", userVO);
	    session.setAttribute("isLogOn", true);
	    //mav.setViewName("redirect:/user/listUsers.do");
	    String action = (String)session.getAttribute("action");
	    session.removeAttribute("action");
	    if(action!= null) {	
	       mav.setViewName("redirect:"+action);
	    }else {
	       mav.setViewName("redirect:/user/listUsers.do");	
	    }

	}else {
	   rAttr.addAttribute("result","loginFailed");
	   mav.setViewName("redirect:/user/loginForm.do");
	}
	
	return mav;
	}

	@Override
	@RequestMapping(value = "/user/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/user/listUsers.do");
		return mav;
	}	

	@RequestMapping(value = "/user/*Form.do", method =  RequestMethod.GET)
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
