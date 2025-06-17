package com.mySpring.myapp.adminPage.admin.service;

import com.mySpring.myapp.adminPage.admin.vo.AdminVO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface AdminService {
	 public List listAdmins() throws DataAccessException;
	 public int addAdmin(AdminVO adminVO) throws DataAccessException;
	 public int removeAdmin(String id) throws DataAccessException;
	 public AdminVO login(AdminVO adminVO) throws Exception;
}
