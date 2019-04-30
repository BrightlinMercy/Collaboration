package com.instagroup.CollaborationBackend.Dao;


import com.instagroup.CollaborationBackend.model.Friend;

public interface FriendDao {

	public boolean addFriend(Friend friend);
	public boolean deleteFriend(Friend friend);
    
}
