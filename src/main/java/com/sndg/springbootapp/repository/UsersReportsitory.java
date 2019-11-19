package com.sndg.springbootapp.repository;

import com.sndg.springbootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersReportsitory extends JpaRepository<User, Long> {
    User findByTelegramId(Long telegramId);
}
