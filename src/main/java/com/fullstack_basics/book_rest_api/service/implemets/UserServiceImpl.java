package com.fullstack_basics.book_rest_api.service.implemets;

import java.util.List;
import com.fullstack_basics.book_rest_api.model.User;
import com.fullstack_basics.book_rest_api.repository.UserRepository;
import com.fullstack_basics.book_rest_api.service.UserService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addData(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateData(User user, int id) {
        User exist = userRepository.findById(id).orElse(null);
        if (exist != null) {
            exist.setName(user.getName());
            exist.setEmail(user.getEmail());
            exist.setPassword(user.getPassword());
            exist.setPhone(user.getPhone());
            userRepository.save(exist);
        }
        return exist;
    }

    @Override
    public String deleteData(int id) {
        JSONObject jsonObject = new JSONObject();
        try {
            userRepository.deleteById(id);
            jsonObject.put("message", "user data deleted");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

}
