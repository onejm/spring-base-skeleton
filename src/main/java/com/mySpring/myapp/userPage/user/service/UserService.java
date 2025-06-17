package com.mySpring.myapp.userPage.user.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.userPage.user.vo.UserVO;

public interface UserService {
	 public List listUsers() throws DataAccessException;
	 public int addUser(UserVO userVO) throws DataAccessException;
	 public int removeUser(String id) throws DataAccessException;
	 public UserVO login(UserVO userVO) throws Exception;
}
