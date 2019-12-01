package com.sndg.springbootapp.users.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sndg.springbootapp.users.controllers.models.UserRequest;
import com.sndg.springbootapp.users.models.User;
import com.sndg.springbootapp.users.models.UserInfo;
import com.sndg.springbootapp.users.repository.UsersInfoRepository;
import com.sndg.springbootapp.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    private final UsersInfoRepository usersInfoRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, UsersInfoRepository usersInfoRepository) {
        this.usersRepository = usersRepository;
        this.usersInfoRepository = usersInfoRepository;
    }

    @Override
    public User getUser(UserRequest userRequest) {
        User user = null;
        if (userRequest.getId() != null){
            Optional<User> optionalUser = usersRepository.findById(userRequest.getId());
            if (optionalUser.isPresent()){
                user = optionalUser.get();
            }
        }else if(!userRequest.getOtherProp().isEmpty()){
//            user = getUserByInfoName("telegramid", userRequest.getTelegramId().toString());
            Optional<List<UserInfo>> optionalUserInfo = null;
            Set<Long> allIds = null;
            int cnt = 0;
            for (HashMap.Entry<String, String> prop: userRequest.getOtherProp().entrySet()){
                optionalUserInfo = usersInfoRepository.findByInfoName(prop.getKey(), prop.getValue());
                if (optionalUserInfo.isPresent()){
                    List<UserInfo> userInfo = optionalUserInfo.get();
                    // TODO: 01.12.2019 закоментить это
                    System.out.println(prop.toString());
                    System.out.println(userInfo.size());
                    System.out.println(userInfo.get(0).toString());
                    System.out.println(userInfo.stream().map(u -> u.getUser().getId()).collect(Collectors.toList()));
                    if (cnt == 0) {
                        allIds =  userInfo.stream().map(u -> u.getUser().getId()).collect(Collectors.toSet());
                        cnt += 1;
                    }else{
                        allIds.retainAll(userInfo.stream().map(u -> u.getUser().getId()).collect(Collectors.toSet()));
                    }
                }else{
                    // TODO: 01.12.2019 спорный момент, можно возвращать только то что нашли, но всегда будет работать по разному
                    allIds = null;
                    break;
                }
            }
            if (allIds != null && allIds.size() == 1){
                user = usersRepository.findById(allIds.iterator().next()).get();
            }
        }
        return user;
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = null;
        if (userRequest.getId() != null){
            Optional<User> optionalUser = usersRepository.findById(userRequest.getId());
            if (optionalUser.isPresent()){
                user = optionalUser.get();
            }
        }else if (userRequest.getOtherProp().get("telegramid") != null){
            user = getUserByInfoName("telegramid", userRequest.getOtherProp().get("telegramid"));
        }
        if (user == null && userRequest.getId() != null && userRequest.getPassword()!= null){
            int hashpassword =  userRequest.getPassword().hashCode();
            user = new User(userRequest.getId(), null, hashpassword);
            Set<UserInfo> userInfo = null;
            usersRepository.save(user);
            for (HashMap.Entry<String, String> param : userRequest.getOtherProp().entrySet()){
                UserInfo info = new UserInfo(user, param.getKey(), param.getValue());
                usersInfoRepository.save(info);
            }
        }
        if (user == null) {
            throw new RuntimeException("required param: \"id\", \"password\"");
        }
        return user;
    }

    @Override
    public User editUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public User loginUser(UserRequest userRequest) {
        User user = null;
        if (userRequest.getId() != null && userRequest.getPassword() != null){
            Optional<User> optionalUser = usersRepository.findById(userRequest.getId());
            if (optionalUser.isPresent() && optionalUser.get().getPassword() == userRequest.getPassword().hashCode()){
                user = optionalUser.get();
            }
        }
        if (user == null){
            throw new RuntimeException("login failed");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = usersRepository.findAll();
        return userList;
    }

    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    public UsersInfoRepository getUsersInfoRepository() {
        return usersInfoRepository;
    }

    private User getUserByInfoName(String infoName, String infoValue){
        User user = null;
        Optional<List<UserInfo>> optionalUserInfo = usersInfoRepository.findByInfoName(infoName, infoValue);
        if (optionalUserInfo.isPresent()){
            List<UserInfo> userInfo = optionalUserInfo.get();
            if (userInfo.size() == 1){
                user = userInfo.get(0).getUser();
            }
        }
        return user;
    }
}
