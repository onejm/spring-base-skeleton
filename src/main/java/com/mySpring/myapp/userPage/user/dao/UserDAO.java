package com.mySpring.myapp.userPage.user.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.userPage.user.vo.UserVO;


public interface UserDAO {
	 public List selectAllUserList() throws DataAccessException;
	 public int insertUser(UserVO userVO) throws DataAccessException ;
	 public int deleteUser(String id) throws DataAccessException;
	 public UserVO loginById(UserVO userVO) throws DataAccessException;

}
