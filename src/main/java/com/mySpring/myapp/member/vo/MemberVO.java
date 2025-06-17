package com.mySpring.myapp.member.vo;

import java.sql.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private UUID id;
	private String userId;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;

	public MemberVO() {
		
	}

	public MemberVO(UUID id, String userId, String pwd, String name, String email) {
		this.id = UUID.randomUUID();
		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public UUID getId() { return id; }

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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
