package com.dsc.procv.Service;


import com.dsc.procv.Model.User;
import com.dsc.procv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

}
