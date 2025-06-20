package com.mySpring.myapp.userPage.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mySpring.myapp.userPage.user.vo.UserVO;


public interface UserController {
	public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addUser(@ModelAttribute("info") UserVO userVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeUser(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("user") UserVO user,
                              RedirectAttributes rAttr,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
}