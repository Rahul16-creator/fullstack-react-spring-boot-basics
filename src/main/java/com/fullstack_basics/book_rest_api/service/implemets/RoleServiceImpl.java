package com.fullstack_basics.book_rest_api.service.implemets;

import java.util.*;

import com.fullstack_basics.book_rest_api.model.Role;
import com.fullstack_basics.book_rest_api.repository.RoleRepository;
import com.fullstack_basics.book_rest_api.service.RoleService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role addData(Role user) {
        return roleRepository.save(user);
    }

    @Override
    public Role updateData(Role role, int id) {
        Role exist = roleRepository.findById(id).orElse(null);
        if (exist != null) {
            exist.setName(role.getName());
            roleRepository.save(exist);
        }
        return exist;
    }

    @Override
    public String deleteData(int id) {
        JSONObject jsonObject = new JSONObject();
        try {
            roleRepository.deleteById(id);
            jsonObject.put("message", "role data deleted");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

}
