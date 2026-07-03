package com.chirag.service;

import com.chirag.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<Integer, User> userDb;

    public UserService(){
        userDb = new HashMap<>();
    }

    public User createUser(User userReq){
        userDb.put(userReq.getId(),userReq);
        return userReq;
    }

    public List<User> getAllUsers(){
        return (List<User>) userDb.values();
    }

    public User getUserById(Integer id){
        return userDb.getOrDefault(id,null);
    }
}
