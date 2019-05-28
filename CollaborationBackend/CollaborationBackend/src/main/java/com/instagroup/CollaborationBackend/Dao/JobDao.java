package com.instagroup.CollaborationBackend.Dao;

import java.util.List;

import com.instagroup.CollaborationBackend.model.Job;

public interface JobDao {
	
	boolean addJob(Job job);

	boolean updateJob(Job job);

	boolean deleteJob(Job job);

	List<Job> selectAllJob();

	Job getOneJob(int jobid);

}
