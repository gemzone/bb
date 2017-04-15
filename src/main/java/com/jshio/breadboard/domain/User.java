package com.jshio.breadboard.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
	private static final long serialVersionUID = 7158611603129981051L;
	
	private Long userId;
	private String name;
	private Integer permission;
	private Boolean admin;
	private Date creationTime;
	private Long oauthNaverId;
	
	public Long getUserId()
	{
		return userId;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Integer getPermission()
	{
		return permission;
	}
	public void setPermission(Integer permission)
	{
		this.permission = permission;
	}
	public Boolean getAdmin()
	{
		return admin;
	}
	public void setAdmin(Boolean admin)
	{
		this.admin = admin;
	}
	public Date getCreationTime()
	{
		return creationTime;
	}
	public void setCreationTime(Date creationTime)
	{
		this.creationTime = creationTime;
	}
	public Long getOauthNaverId()
	{
		return oauthNaverId;
	}
	public void setOauthNaverId(Long oauthNaverId)
	{
		this.oauthNaverId = oauthNaverId;
	}

}
