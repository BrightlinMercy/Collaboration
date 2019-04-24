package com.instagroup.CollaborationBackend.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.instagroup.CollaborationBackend.Dao.BlogDao;
import com.instagroup.CollaborationBackend.model.Blog;

public class BlogDaoTestCase {

	
	static BlogDao blogDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.instagroup.CollaborationBackend");
		context.refresh();
		
		blogDao=(BlogDao)context.getBean("blogDao");
		
	}
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogname("JAVA EE");
		blog.setBlogcontent("this blog is about the testing");
		blog.setCreatedate(new java.util.Date());
		blog.setLikes(1);
		blog.setDislike(1);
		blog.setUsername("mercy");
		blog.setStatus("NA");
		assertTrue("problem in adding blog", blogDao.addBlog(blog));
	}
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDao.getBlog(954);
		assertTrue("problem in approving", blogDao.approveBlog(blog));

	}
	@Test
	public void incrementLikesBlogTest()
	{
		Blog blog=blogDao.getBlog(954);
		assertTrue("problem in increment", blogDao.incrementLikes(blog));

	}
}

