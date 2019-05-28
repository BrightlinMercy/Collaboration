package com.instagroup.CollaborationMiddleware.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagroup.CollaborationBackend.Dao.ForumCommentDao;
import com.instagroup.CollaborationBackend.model.ForumComment;

@RestController
@RequestMapping("/forumcomment")
public class ForumCommentController {

	@Autowired
	ForumCommentDao forumCommentDao;
	
	@PostMapping
	ResponseEntity<Void> createForumComment(@RequestBody ForumComment forumcomment) {
		forumcomment.setFcommentdate(new Date());
		if (forumCommentDao.addForumComment(forumcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PutMapping("/updateForumComment/{fcommentid}/{comment}")
	ResponseEntity<Void> updateForumComment(@PathVariable("fcommentid") int fcommentid,@PathVariable("comment") String forumcomment) {
		ForumComment forumComment=forumCommentDao.getForumComment(fcommentid);
		forumComment.setFcommentdate(new Date());
		forumComment.setForumcomment(forumcomment);
		if (forumCommentDao.updateForumComment(forumComment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

	}
	
	@DeleteMapping("/{fcommentid}")
	ResponseEntity<ForumComment> deleteForumComment(@PathVariable("fcommentid") int fcommentid) {
		if (forumCommentDao.deleteForumComment(forumCommentDao.getForumComment(fcommentid)))
			return new ResponseEntity<ForumComment>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<ForumComment>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping
	ResponseEntity<List<ForumComment>> viewAllForumComment()
	{
		List<ForumComment> forumComment=forumCommentDao.listForumComment(); 
		if(forumComment.isEmpty())
			return new ResponseEntity<List<ForumComment>>(forumComment,HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<ForumComment>>(forumComment,HttpStatus.ACCEPTED); 
	}
	

}
