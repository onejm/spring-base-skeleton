package com.mySpring.myapp.adminPage.admin.dao;

import com.mySpring.myapp.adminPage.admin.vo.AdminVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllAdminList() throws DataAccessException {
		List<AdminVO> adminsList = null;
		adminsList = sqlSession.selectList("mapper.admin.selectAllAdminList");
		return adminsList;
	}

	@Override
	public int insertAdmin(AdminVO adminVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.admin.insertAdmin", adminVO);
		return result;
	}

	@Override
	public int deleteAdmin(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.admin.deleteAdmin", id);
		System.out.println("delete Result : " + result);
		return result;
	}
	
	@Override
	public AdminVO loginById(AdminVO adminVO) throws DataAccessException{
		  AdminVO vo = sqlSession.selectOne("mapper.admin.loginById",adminVO);
		return vo;
	}

}
