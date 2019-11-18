package com.sndg.springbootapp.repository;


import com.sndg.springbootapp.model.JobLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobListReportsitory extends JpaRepository<JobLists, Long> {
    List<JobLists> findByUserId(Long userId);
}
