package com.sndg.springbootapp.repository;


import com.sndg.springbootapp.model.JobList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobListReportsitory extends JpaRepository<JobList, Long> {
    List<JobList> findByUserId(Long userId);
}
