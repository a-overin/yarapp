package com.sndg.springbootapp.jobs.controllers;

import com.sndg.springbootapp.jobs.controllers.models.JobListResponse;
import com.sndg.springbootapp.jobs.models.JobList;
import com.sndg.springbootapp.users.models.User;
import com.sndg.springbootapp.jobs.repository.JobListRepository;
import com.sndg.springbootapp.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joblists")
public class JobListControllerImpl implements JobListController{


    private JobListRepository jobListReportsitory;

    private UsersRepository usersReportsitory;

    @Autowired
    public JobListControllerImpl(JobListRepository jobListReportsitory, UsersRepository usersReportsitory) {
        this.jobListReportsitory = jobListReportsitory;
        this.usersReportsitory = usersReportsitory;
    }

//    @GetMapping()
//    public List<JobList> getJobListById(@RequestParam(value = "id") Long userid){
//        List<JobList> jobLists = jobListReportsitory.findByUserId(userid);
//        return jobLists;
//    }
//
//    @PostMapping(consumes = "application/json", produces = "application/json")
//    public JobList createJob(@RequestBody HashMap<String, String> paramsList) {
//        Optional<User> optionalUser = usersReportsitory.findById(Long.parseLong(paramsList.get("id").toString()));
//        User user = null;
//        if (optionalUser.isPresent()){
//            user = optionalUser.get();
//        }
//        String title = paramsList.get("title").toString();
//        String description = paramsList.get("description").toString();
//        JobList jobList = null;
//        if (user != null && description != null && title != null){
//            jobList = new JobList(user, title, description);
//            jobListReportsitory.save(jobList);
//        }
//        if (jobList != null){
//            return jobList;
//        }else{
//            return null;
//        }
//
//    }

    @Override
    public List<JobListResponse> getJobListById(Long id) {
        return null;
    }

    @Override
    public JobListResponse createJob(HashMap<String, String> paramList) {
        return null;
    }

    @Override
    public JobListResponse editJob(HashMap<String, String> paramList) {
        return null;
    }

}
