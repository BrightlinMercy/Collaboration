package com.instagroup.CollaborationBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagroup.CollaborationBackend.Dao.BlogDao;
import com.instagroup.CollaborationBackend.model.Blog;
import com.instagroup.CollaborationBackend.model.LikeDislike;

@Repository
@Transactional
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Blog getBlog(int blogid) {
		try {
			return (Blog) sessionFactory.getCurrentSession().createQuery("from Blog where blogid=" + blogid)
					.uniqueResult();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Blog> selectUserBlog(int userid) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where user.userid=" + userid).list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public List<Blog> selectAllBlog()  {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	@Override
	public List<Blog> selectApprovedBlog() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where status='" + true + "'").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	
}
