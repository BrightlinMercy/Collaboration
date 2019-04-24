package com.instagroup.CollaborationBackend.Dao;

import java.util.List;

import com.instagroup.CollaborationBackend.model.BlogComment;

public interface BlogCommentDao {
	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteBlogComment(BlogComment blogComment);

	public BlogComment getBlogComment(int commentid);

	public List<BlogComment> listBlogComment(int blogid);
	
	

}
