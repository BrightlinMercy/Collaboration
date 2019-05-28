
package com.instagroup.CollaborationMiddleware.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagroup.CollaborationBackend.Dao.BlogDao;
import com.instagroup.CollaborationBackend.Dao.UserDao;
import com.instagroup.CollaborationBackend.model.Blog;

@RestController

@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogDao blogDao;

	@Autowired
	UserDao userDao;

	@PostMapping
	ResponseEntity<Void> createBlog(@RequestBody Blog blog, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			blog.setUser(userDao.selectOneUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			//blog.setCreatedate(new Date());
			if (blogDao.addBlog(blog))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

		}

	}
	
	@PostMapping("/updateBlog")
	ResponseEntity<Void> updateBlog(@RequestBody Blog blog, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			blog.setUser(userDao.selectOneUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			//blog.setCreatedate(new Date());
			if (blogDao.updateBlog(blog))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/{blogid}")
	ResponseEntity<Blog> deleteBlog(@PathVariable("blogid") int blogid) {
		if (blogDao.deleteBlog(blogDao.getBlog(blogid)))
			return new ResponseEntity<Blog>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Blog>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping
	ResponseEntity<List<Blog>> viewAllBlog() {
		List<Blog> blog = blogDao.selectAllBlog();
		if (blog.isEmpty())
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/approved")
	ResponseEntity<List<Blog>> viewApprovedBlog() {
		List<Blog> blog = blogDao.selectApprovedBlog();
		if (blog.isEmpty())
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
}
	@GetMapping("/user/{userid}")
	ResponseEntity<List<Blog>> viewUserBlog(@PathVariable("userid") int userid) {
		List<Blog> blog = blogDao.selectUserBlog(userid);
		if (blog == null)
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}
	@GetMapping("/{blogid}")
	ResponseEntity<Blog> viewOneBlog(@PathVariable("blogid") int blogid) {
		Blog blog = blogDao.getBlog(blogid);
		if (blog == null)
			return new ResponseEntity<Blog>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Blog>(blog, HttpStatus.ACCEPTED);
	}



}
