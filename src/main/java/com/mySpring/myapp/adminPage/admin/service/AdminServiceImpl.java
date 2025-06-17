package com.mySpring.myapp.adminPage.admin.service;

import com.mySpring.myapp.adminPage.admin.dao.AdminDAO;
import com.mySpring.myapp.adminPage.admin.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("adminService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List listAdmins() throws DataAccessException {
		List adminsList = null;
		adminsList = adminDAO.selectAllAdminList();
		return adminsList;
	}

	@Override
	public int addAdmin(AdminVO admin) throws DataAccessException {
		return adminDAO.insertAdmin(admin);
	}

	@Override
	public int removeAdmin(String id) throws DataAccessException {
		return adminDAO.deleteAdmin(id);
	}
	
	@Override
	public AdminVO login(AdminVO adminVO) throws Exception{
		return adminDAO.loginById(adminVO);
	}

}
