package com.mySpring.myapp.adminPage.admin.vo;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@Component("adminVO")
public class AdminVO {
	private String id;
	private String userId;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private Date joinDate;

	public AdminVO() {
		this.id = UUID.randomUUID().toString();
	}

	public AdminVO(String userId, String pwd, String name, String email, String phone) {
		this.id = UUID.randomUUID().toString();
		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {return phone;}

	public void setPhone(String phone) {this.phone = phone;}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
