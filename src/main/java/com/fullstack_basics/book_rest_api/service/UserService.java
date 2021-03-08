package com.fullstack_basics.book_rest_api.service;

import java.util.*;

import com.fullstack_basics.book_rest_api.model.User;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    User addData(User user);

    User updateData(User role, int id);

    String deleteData(int id);

}
