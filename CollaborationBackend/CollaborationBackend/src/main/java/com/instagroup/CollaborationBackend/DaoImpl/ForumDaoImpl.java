package com.instagroup.CollaborationBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagroup.CollaborationBackend.Dao.ForumDao;
import com.instagroup.CollaborationBackend.model.Forum;
@Repository
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	public boolean addForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean deleteForum(Forum forum){
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateForum(Forum forum){
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public Forum getForum(int forumid){
		try
		{
			return(Forum)sessionFactory.getCurrentSession().createQuery("from Forum where forumid="+forumid).uniqueResult();
		}
		catch (Exception e) {
		
		return null;
	}
	}

	@Override
	public List<Forum> selectAllForums() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Forum").list();
		}
		catch (Exception e) {
		return null;
	}
	}

	@Override
	public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean rejectForum(Forum forum) {
		try
		{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

}
