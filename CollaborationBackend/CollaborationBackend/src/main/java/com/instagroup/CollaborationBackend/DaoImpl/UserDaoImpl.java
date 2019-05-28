package com.instagroup.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagroup.CollaborationBackend.Dao.UserDao;
import com.instagroup.CollaborationBackend.model.UserDetail;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetail user) {
		try {
			user.setIsonline("false");
			user.setStatus("Offline");
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public UserDetail checkUser(UserDetail user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail getUser(String emailid) {
		try {
			return (UserDetail) sessionFactory.getCurrentSession().createQuery("from UserDetail where emailid='" + emailid + "'")
					.uniqueResult();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public UserDetail selectOneUser(int userid) {
		try {
			return (UserDetail) sessionFactory.getCurrentSession().createQuery("from UserDetail where userid=" + userid)
					.uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean makeOffline(UserDetail user) {
		// TODO Auto-generated method stub
		user.setIsonline("false");
		user.setStatus("Offline");

		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean makeOnline(UserDetail user){
		// TODO Auto-generated method stub
		user.setIsonline("true");
		user.setStatus("Onine");

		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<UserDetail> selectAllUsers() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from UserDetail").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}