package com.instagroup.CollaborationMiddleware.restcontroller;

import java.util.Date;
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

import com.instagroup.CollaborationBackend.Dao.ForumDao;
import com.instagroup.CollaborationBackend.Dao.UserDao;
import com.instagroup.CollaborationBackend.model.Forum;

@RestController
@RequestMapping("/forum")
public class ForumController {
	
	@Autowired
	ForumDao forumDao;

	@Autowired
	UserDao userDao;
	
	@PostMapping
	ResponseEntity<Void> createForum(@RequestBody Forum forum, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			forum.setUser(userDao.selectOneUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			forum.setCreatedate(new Date());
			if (forumDao.addForum(forum))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("/update")
	ResponseEntity<Void> updateForum(@RequestBody Forum forum, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			forum.setUser(userDao.selectOneUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			forum.setCreatedate(new Date());
			if (forumDao.updateForum(forum))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	@DeleteMapping("/{forumid}")
	ResponseEntity<Forum> deleteBlog(@PathVariable("forumid") int forumid) {
		if (forumDao.deleteForum(forumDao.getForum(forumid)))
			return new ResponseEntity<Forum>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Forum>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping
	ResponseEntity<List<Forum>> viewAllForum() {
		List<Forum> forum = forumDao.selectAllForums();
		if (forum.isEmpty())
			return new ResponseEntity<List<Forum>>(forum, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Forum>>(forum, HttpStatus.ACCEPTED);
	}
	@GetMapping("/{forumid}")
	ResponseEntity<Forum> viewOneForum(@PathVariable("forumid") int forumid) {
		Forum forum = forumDao.getForum(forumid);
		if (forum == null)
			return new ResponseEntity<Forum>(forum, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Forum>(forum, HttpStatus.ACCEPTED);
	}
	
}
