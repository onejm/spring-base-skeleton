package com.mySpring.myapp.adminPage.admin.controller;

import com.mySpring.myapp.adminPage.admin.vo.AdminVO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AdminController {
	public ModelAndView listAdmins(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addAdmin(@ModelAttribute("info") AdminVO adminVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeAdmin(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("admin") AdminVO admin,
                              RedirectAttributes rAttr,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
}