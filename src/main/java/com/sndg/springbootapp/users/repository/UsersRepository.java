package com.sndg.springbootapp.users.repository;

import com.sndg.springbootapp.users.models.User;
import com.sndg.springbootapp.users.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
