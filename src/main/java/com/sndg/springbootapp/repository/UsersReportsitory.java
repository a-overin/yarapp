package com.sndg.springbootapp.repository;

import com.sndg.springbootapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersReportsitory extends JpaRepository<Users, Long> {
//    List<Users> findByUserId(Long userId);
}
