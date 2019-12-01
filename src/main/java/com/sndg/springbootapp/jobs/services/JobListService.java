package com.sndg.springbootapp.jobs.services;

import com.sndg.springbootapp.jobs.models.JobList;
import com.sndg.springbootapp.users.models.User;

import java.util.List;

public interface JobListService {

    public JobList createJob(JobList job);

    public List<JobList> getJobListByUser(User user);

    public JobList editJob(JobList job);
}
