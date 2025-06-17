package com.mySpring.myapp.userPage.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.myapp.userPage.user.dao.UserDAO;
import com.mySpring.myapp.userPage.user.vo.UserVO;



@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public List listUsers() throws DataAccessException {
		List usersList = null;
		usersList = userDAO.selectAllUserList();
		return usersList;
	}

	@Override
	public int addUser(UserVO user) throws DataAccessException {
		return userDAO.insertUser(user);
	}

	@Override
	public int removeUser(String id) throws DataAccessException {
		return userDAO.deleteUser(id);
	}
	
	@Override
	public UserVO login(UserVO userVO) throws Exception{
		return userDAO.loginById(userVO);
	}

}
