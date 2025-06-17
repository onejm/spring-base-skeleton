package com.mySpring.myapp.adminPage.admin.dao;

import com.mySpring.myapp.adminPage.admin.vo.AdminVO;
import org.springframework.dao.DataAccessException;

import java.util.List;


public interface AdminDAO {
	 public List selectAllAdminList() throws DataAccessException;
	 public int insertAdmin(AdminVO adminVO) throws DataAccessException ;
	 public int deleteAdmin(String id) throws DataAccessException;
	 public AdminVO loginById(AdminVO adminVO) throws DataAccessException;

}
