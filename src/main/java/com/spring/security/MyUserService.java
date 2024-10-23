package com.spring.security;

import com.spring.security.model.AuthenticationResponse;
import com.spring.security.model.MyUser;
import com.spring.security.repo.UserRepository;
import com.spring.security.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {

    private final UserRepository repository;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public MyUserService(UserRepository repository,
                         TokenService tokenService,
                         AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthenticationResponse saveUser(MyUser user) {
        user.setRole(user.getRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        MyUser saveUser = repository.save(user);
        String token = tokenService.generateToken(saveUser);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(MyUser myUser) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                myUser.getUsername(),
                myUser.getPassword())
        );
        MyUser user = repository.findByUsername(myUser.getUsername());
        String token = tokenService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public List<MyUser> getAllUsers(){
        return repository.findAll();
    }
}
