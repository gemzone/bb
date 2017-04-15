package com.jshio.breadboard.domain;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable
{
	private static final long serialVersionUID = -8324213984344070507L;
	
	private Long boardId;
	private String id;
	private String title;
	private String description;
	private String memo;
	private Long postCount;
	private Long commentCount;
	private Integer grantList;
	private Integer grantView;
	private Integer grantWrite;
	private Integer grantComment;
	private Integer grantDelete;
	private Integer grantNotice;
	private Integer grantSecret;
	private Date creationTime;
	
	public Long getBoardId()
	{
		return boardId;
	}
	public void setBoardId(Long boardId)
	{
		this.boardId = boardId;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getMemo()
	{
		return memo;
	}
	public void setMemo(String memo)
	{
		this.memo = memo;
	}
	public Long getPostCount()
	{
		return postCount;
	}
	public void setPostCount(Long postCount)
	{
		this.postCount = postCount;
	}
	public Long getCommentCount()
	{
		return commentCount;
	}
	public void setCommentCount(Long commentCount)
	{
		this.commentCount = commentCount;
	}
	public Integer getGrantList()
	{
		return grantList;
	}
	public void setGrantList(Integer grantList)
	{
		this.grantList = grantList;
	}
	public Integer getGrantView()
	{
		return grantView;
	}
	public void setGrantView(Integer grantView)
	{
		this.grantView = grantView;
	}
	public Integer getGrantWrite()
	{
		return grantWrite;
	}
	public void setGrantWrite(Integer grantWrite)
	{
		this.grantWrite = grantWrite;
	}
	public Integer getGrantComment()
	{
		return grantComment;
	}
	public void setGrantComment(Integer grantComment)
	{
		this.grantComment = grantComment;
	}
	public Integer getGrantDelete()
	{
		return grantDelete;
	}
	public void setGrantDelete(Integer grantDelete)
	{
		this.grantDelete = grantDelete;
	}
	public Integer getGrantNotice()
	{
		return grantNotice;
	}
	public void setGrantNotice(Integer grantNotice)
	{
		this.grantNotice = grantNotice;
	}
	public Integer getGrantSecret()
	{
		return grantSecret;
	}
	public void setGrantSecret(Integer grantSecret)
	{
		this.grantSecret = grantSecret;
	}
	public Date getCreationTime()
	{
		return creationTime;
	}
	public void setCreationTime(Date creationTime)
	{
		this.creationTime = creationTime;
	}
	
	
	
	
	
}