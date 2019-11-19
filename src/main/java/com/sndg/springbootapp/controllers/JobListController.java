package com.sndg.springbootapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sndg.springbootapp.model.JobList;
import com.sndg.springbootapp.model.User;
import com.sndg.springbootapp.repository.JobListReportsitory;
import com.sndg.springbootapp.repository.UsersReportsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class JobListController {

    @Autowired
    private JobListReportsitory jobListReportsitory;

    @Autowired
    private UsersReportsitory usersReportsitory;

    @GetMapping("/joblists")
    public List<JobList> getJobListById(@RequestParam(value = "id") Long userid){
        List<JobList> jobLists = jobListReportsitory.findByUserId(userid);
        return jobLists;
    }

    @PostMapping(path = "/joblists", consumes = "application/json", produces = "application/json")
    public JobList createJob(@RequestBody String params) throws JsonProcessingException {
        HashMap<String, Object> paramsList = new ObjectMapper().readValue(params, HashMap.class);
        Optional<User> optionalUser = usersReportsitory.findById(Long.parseLong(paramsList.get("id").toString()));
        User user = null;
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }
        String title = paramsList.get("title").toString();
        String description = paramsList.get("description").toString();
        JobList jobList = null;
        if (user != null && description != null && title != null){
            jobList = new JobList(user, title, description);
            jobListReportsitory.save(jobList);
        }
        if (jobList != null){
            return jobList;
        }else{
            return null;
        }

    }
}
