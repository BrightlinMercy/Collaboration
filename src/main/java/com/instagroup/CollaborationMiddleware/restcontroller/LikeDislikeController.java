package com.instagroup.CollaborationMiddleware.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagroup.CollaborationBackend.Dao.BlogDao;
import com.instagroup.CollaborationBackend.Dao.LikeDislikeDao;
import com.instagroup.CollaborationBackend.model.LikeDislike;

@RestController
@RequestMapping("likedislike")
public class LikeDislikeController {
	
	@Autowired
	BlogDao blogDao; 
	@Autowired 
	LikeDislikeDao likedislikeDao;
	
	@GetMapping("{blogid}")
	ResponseEntity<LikeDislike> getBloglikes(@PathVariable("blogid") int blogid)
	{
		LikeDislike blog=likedislikeDao.selectLikeDislike(blogid);
		if(blog!=null)
		{
			return new ResponseEntity<LikeDislike>(blog,HttpStatus.ACCEPTED);
		}
		else
		{
			LikeDislike blog1=new LikeDislike();
			blog1.setBlog(blogDao.getBlog(blogid));
			return new ResponseEntity<LikeDislike>(blog1,HttpStatus.FOUND);
			
		}
	}
	
	@PostMapping
	ResponseEntity<Void> InsertOrUpdateBlogLike(@RequestBody LikeDislike likedislike)
	{
		if(likedislikeDao.updateLikeDislike(likedislike))
		{
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	


}
