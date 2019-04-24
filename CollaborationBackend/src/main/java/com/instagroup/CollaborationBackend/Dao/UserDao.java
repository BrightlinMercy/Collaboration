package com.instagroup.CollaborationBackend.Dao;

import com.instagroup.CollaborationBackend.model.User;

public interface UserDao {
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User checkUser(User user);
	public User getUser(String emailid);

}
