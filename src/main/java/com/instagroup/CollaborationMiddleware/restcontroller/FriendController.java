package com.instagroup.CollaborationMiddleware.restcontroller;

import java.util.List;

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

import com.instagroup.CollaborationBackend.Dao.FriendDao;
import com.instagroup.CollaborationBackend.model.Friend;

@RestController
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	FriendDao friendDao;
	
	@PostMapping
	ResponseEntity<Void> createFriend(@RequestBody Friend friend) {
		if (friendDao.createFriend(friend))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/update")
	ResponseEntity<Void> updateFriend(@RequestBody Friend friend) {
		if (friendDao.updateFriend(friend))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("/{friendid}")
	ResponseEntity<Friend> deleteFriend(@PathVariable("friendid") int friendid) {
		if (friendDao.deleteFriend(friendDao.selectOneFriend(friendid)))
			return new ResponseEntity<Friend>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Friend>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping
	ResponseEntity<List<Friend>> viewAllFriend() {
		List<Friend> friend = friendDao.selectAllFriend();
		if (friend.isEmpty())
			return new ResponseEntity<List<Friend>>(friend, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Friend>>(friend, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{friendid}")
	ResponseEntity<Friend> viewOneFriend(@PathVariable("friendid") int friendid) {
		Friend friend = friendDao.selectOneFriend(friendid);
		if (friend == null)
			return new ResponseEntity<Friend>(friend, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Friend>(friend, HttpStatus.ACCEPTED);
	}
	
}
