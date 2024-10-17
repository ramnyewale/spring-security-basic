package com.spring.security;

import com.spring.security.model.MyUser;
import com.spring.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class MyUserService {

    @Autowired
    private UserRepository repository;

    public MyUser saveUser(MyUser user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        return repository.save(user);
    }

    public List<MyUser> getAllUsers(){
        return repository.findAll();
    }
}
