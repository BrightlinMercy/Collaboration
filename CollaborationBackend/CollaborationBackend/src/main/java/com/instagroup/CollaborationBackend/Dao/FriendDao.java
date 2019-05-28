package com.instagroup.CollaborationBackend.Dao;


import java.util.List;

import com.instagroup.CollaborationBackend.model.Friend;

public interface FriendDao {

	boolean createFriend(Friend friend);

	boolean updateFriend(Friend friend);

	boolean deleteFriend(Friend friend);

	List<Friend> selectAllFriend();

	Friend selectOneFriend(int friendid);

}
