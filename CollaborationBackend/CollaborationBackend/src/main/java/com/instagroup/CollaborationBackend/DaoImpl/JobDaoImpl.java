package com.instagroup.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagroup.CollaborationBackend.Dao.JobDao;
import com.instagroup.CollaborationBackend.model.Job;

@Repository("jobDao")
@Transactional

public class JobDaoImpl implements JobDao {
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public boolean addJob(Job job) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public boolean deleteJob(Job job) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Job> selectAllJob() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Job").list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Job getOneJob(int jobid) {
		// TODO Auto-generated method stub
		try {
			return (Job) sessionFactory.getCurrentSession().createQuery("from Job where jobid=" + jobid)
					.uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
