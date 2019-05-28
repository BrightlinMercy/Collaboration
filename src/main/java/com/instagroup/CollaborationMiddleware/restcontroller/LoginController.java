package com.instagroup.CollaborationMiddleware.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instagroup.CollaborationBackend.Dao.UserDao;
import com.instagroup.CollaborationBackend.model.UserDetail;

@RestController
public class LoginController {

	@Autowired
	UserDao userDao;

	@PostMapping("/login")
	ResponseEntity<UserDetail> loginpage(@RequestBody UserDetail userdetail, HttpSession httpSession) {
		UserDetail existinguser = userDao.getUser(userdetail.getEmailid());
		if (existinguser.getPassword().equals(userdetail.getPassword())) {
			httpSession.setAttribute("userid", existinguser.getUserid());
			httpSession.setAttribute("useremail", existinguser.getEmailid());
			return new ResponseEntity<UserDetail>(existinguser, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<UserDetail>(existinguser, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/logout")
	public ResponseEntity<Void> logoutpage(HttpSession httpSession) {
		UserDetail exisitinguser = userDao.getUser(httpSession.getAttribute("useremail").toString());
		exisitinguser.setIsonline("false");

		if (userDao.updateUser(exisitinguser)) {
			httpSession.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}