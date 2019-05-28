package com.instagroup.CollaborationBackend.Dao;

import com.instagroup.CollaborationBackend.model.LikeDislike;

public interface LikeDislikeDao {
	
	public boolean updateLikeDislike(LikeDislike likedislike);
	   public LikeDislike selectLikeDislike(int blogId);

}
