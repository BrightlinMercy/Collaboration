package com.instagroup.CollaborationBackend.Dao;

import java.util.List;

import com.instagroup.CollaborationBackend.model.ForumComment;

public interface ForumCommentDao {
	
	public boolean addForumComment(ForumComment forumComment);

	public boolean deleteForumComment(ForumComment forumComment);
	
	public boolean updateForumComment(ForumComment forumComment);

	public ForumComment getForumComment(int fcommentid);

	public List<ForumComment> listForumComment();
	

}
