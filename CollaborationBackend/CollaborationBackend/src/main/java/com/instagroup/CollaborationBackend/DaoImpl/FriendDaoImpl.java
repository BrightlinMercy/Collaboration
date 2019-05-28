package com.instagroup.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagroup.CollaborationBackend.Dao.FriendDao;
import com.instagroup.CollaborationBackend.model.Friend;

@Repository("friendDao")
@Transactional

public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public boolean createFriend(Friend friend) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateFriend(Friend friend) 
	{
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(friend);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Friend> selectAllFriend() {
		// TODO Auto-generated method stub
		try{
			return sessionFactory.getCurrentSession().createQuery("from Friend").list();
			
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Friend selectOneFriend(int friendid) {
		// TODO Auto-generated method stub
		try
		{
		return (Friend)sessionFactory.getCurrentSession().createQuery("from Friend where friendid="+friendid).uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteFriend(Friend friend){
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
