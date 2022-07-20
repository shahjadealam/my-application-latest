package com.myapp.api.service;

import com.myapp.api.dto.UserRequest;
import com.myapp.api.entity.User;
import com.myapp.api.exception.ApplicationInternalException;
import com.myapp.api.exception.UserNotFoundException;
import com.myapp.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest) {
        User user = new User(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }

    public List<User> getALlUsers() throws ApplicationInternalException {
        List<User> users = repository.findAll();
        if(!CollectionUtils.isEmpty(users)) {
            return users;
        }
        else{
            throw new ApplicationInternalException("NO_RECORD_FOUND");
        }
    }


    public User getUser(int id) throws UserNotFoundException {
        User user= repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("USER_NOT_FOUND", id);
        }
    }

    public void deleteUSer(int id) throws UserNotFoundException {
        User user= repository.findByUserId(id);
        if(user != null){
            repository.deleteById(id);
        }else{
            throw new UserNotFoundException("USER_NOT_FOUND", id);
        }
    }

    public String getMailStatus(String email){
        return "success";
    }
}
