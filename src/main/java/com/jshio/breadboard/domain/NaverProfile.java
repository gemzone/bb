package com.jshio.breadboard.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NaverProfile implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6695499445401920504L;

	@Id         
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String birthday;
	private String profileImage;		// profile_image
	private String gender;
	private String encId;				// enc_id
	private String nickname;
	private String name;
	private String email;
	private String age;
	
	public NaverProfile(String birthday,
			String profileImage,
			String gender,
			String encId,
			String nickname,
			String name,
			long id,
			String email,
			String age)
	{
		this.birthday = birthday;
		this.profileImage = profileImage;
		this.gender = gender;
		this.encId = encId;
		this.nickname = nickname;
		this.name = name;
		this.id = id;
		this.email = email;
		this.age = age;
	}
	
	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	public String getProfileImage()
	{
		return profileImage;
	}
	public void setProfileImage(String profileImage)
	{
		this.profileImage = profileImage;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getEncId()
	{
		return encId;
	}
	public void setEncId(String encId)
	{
		this.encId = encId;
	}
	public String getNickname()
	{
		return nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	
	
	
	
	
	
	
}
