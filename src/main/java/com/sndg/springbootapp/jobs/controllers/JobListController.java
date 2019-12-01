package com.sndg.springbootapp.jobs.controllers;

import com.sndg.springbootapp.jobs.controllers.models.JobListResponse;
import com.sndg.springbootapp.jobs.models.JobList;

import java.util.HashMap;
import java.util.List;

public interface JobListController {

    List<JobListResponse> getJobListById(Long id);

    JobListResponse createJob(HashMap<String, String> paramList);

    JobListResponse editJob(HashMap<String, String> paramList);
}
