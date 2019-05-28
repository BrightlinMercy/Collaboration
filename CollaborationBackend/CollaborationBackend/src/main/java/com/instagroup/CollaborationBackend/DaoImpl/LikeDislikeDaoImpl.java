package com.instagroup.CollaborationBackend.DaoImpl;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagroup.CollaborationBackend.Dao.LikeDislikeDao;
import com.instagroup.CollaborationBackend.model.LikeDislike;
@Repository
@Transactional

public class LikeDislikeDaoImpl implements LikeDislikeDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean updateLikeDislike(LikeDislike ld) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(ld);
return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public LikeDislike selectLikeDislike(int blogId) {
		// TODO Auto-generated method stub
		try {
			return (LikeDislike) sessionFactory.getCurrentSession().createQuery("from LikeDislike where blogid=" + blogId).uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

}}
