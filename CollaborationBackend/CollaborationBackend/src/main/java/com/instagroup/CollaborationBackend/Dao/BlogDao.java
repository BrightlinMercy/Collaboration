package com.instagroup.CollaborationBackend.Dao;

import java.util.List;

import com.instagroup.CollaborationBackend.model.Blog;

public interface BlogDao {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
    public Blog getBlog(int blogid);
	List<Blog> selectUserBlog(int userid);
    
    public boolean approveBlog(Blog blog);
    public boolean rejectBlog(Blog blog);
	List<Blog> selectApprovedBlog();
	public List<Blog> selectAllBlog();
   
}
