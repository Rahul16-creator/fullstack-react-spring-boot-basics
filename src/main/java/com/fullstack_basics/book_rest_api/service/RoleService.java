package com.fullstack_basics.book_rest_api.service;

import java.util.*;
import com.fullstack_basics.book_rest_api.model.Role;

public interface RoleService {

    List<Role> findAll();

    Role findById(int id);

    Role addData(Role role);

    Role updateData(Role role, int id);

    String deleteData(int id);
}
