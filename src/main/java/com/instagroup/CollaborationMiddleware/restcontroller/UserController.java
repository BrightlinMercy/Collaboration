package com.instagroup.CollaborationMiddleware.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagroup.CollaborationBackend.Dao.UserDao;
import com.instagroup.CollaborationBackend.model.UserDetail;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping
	ResponseEntity<Void> registerUser(@RequestBody UserDetail user) {
		if (userDao.registerUser(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/update")
	ResponseEntity<Void> updateUser(@RequestBody UserDetail user) {
		if (userDao.updateUser(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/{userid}")
	ResponseEntity<UserDetail> viewOneUser(@PathVariable("userid") int userid) {
		UserDetail user = userDao.selectOneUser(userid);
		if (user== null)
			return new ResponseEntity<UserDetail>(user, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<UserDetail>(user, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/online/{userid}")
	ResponseEntity<Void> makeOnLine(@PathVariable("userid") int userid) {
		UserDetail user = userDao.selectOneUser(userid);
		if (userDao.makeOnline(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	@PostMapping("/offline/{userid}")
	ResponseEntity<Void> makeOffLine(@PathVariable("userid") int userid) {
		UserDetail user = userDao.selectOneUser(userid);
		if (userDao.makeOffline(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping	
	ResponseEntity<List<UserDetail>> viewAllUsers() {
		System.out.println("fdgfdg");
		List<UserDetail> user = userDao.selectAllUsers();
		if (user.isEmpty())
			return new ResponseEntity<List<UserDetail>>(user, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<UserDetail>>(user, HttpStatus.ACCEPTED);
	}
}
