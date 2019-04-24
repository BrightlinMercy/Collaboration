package com.instagroup.CollaborationBackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Forum {

	@Column
	@Id
	private int forumid;
	
	@Column(nullable=false)
	private String forumname;
	
	@Column(nullable=false)
	private String forumcontent;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private Date createdate;
	
	@Column(nullable=false)
	private String status;

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getForumname() {
		return forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

	public String getForumcontent() {
		return forumcontent;
	}

	public void setForumcontent(String forumcontent) {
		this.forumcontent = forumcontent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
