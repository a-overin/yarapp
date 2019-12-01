package com.sndg.springbootapp.users.repository;

import com.sndg.springbootapp.users.models.User;
import com.sndg.springbootapp.users.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UsersInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<Set<UserInfo>> findByUser(User user);
    @Query(value = "select * from users_info ui where info_name = :infoName and info_value = :infoValue", nativeQuery = true)
    Optional<List<UserInfo>> findByInfoName(@Param("infoName")String infoName, @Param("infoValue")String infoValue);
//    @Query("select * from users_info ui join users u on u.id = ui.user_id where ui.info_name = ")
//    Optional<UserInfo> findByInfoNameAndUser(User user, String infoName);
}
