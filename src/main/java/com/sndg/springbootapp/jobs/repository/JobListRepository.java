package com.sndg.springbootapp.jobs.repository;


import com.sndg.springbootapp.jobs.models.JobList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobListRepository extends JpaRepository<JobList, Long> {
    List<JobList> findByUserId(Long userId);
}
