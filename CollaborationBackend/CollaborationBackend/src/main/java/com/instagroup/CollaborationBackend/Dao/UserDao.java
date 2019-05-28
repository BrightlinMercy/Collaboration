package com.instagroup.CollaborationBackend.Dao;

import java.util.List;

import com.instagroup.CollaborationBackend.model.UserDetail;

public interface UserDao {
	
	public boolean registerUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public UserDetail checkUser(UserDetail user);
	public UserDetail getUser(String emailid);
	public UserDetail selectOneUser(int userid);
	boolean makeOffline(UserDetail user);
	boolean makeOnline(UserDetail user);
	List<UserDetail> selectAllUsers();

}
