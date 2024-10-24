package com.spring.security.service;

import com.spring.security.model.JwtTokenResponse;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       JwtTokenService jwtTokenService,
                       AuthenticationManager authenticationManager,
                       PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.jwtTokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public String createUser(User user) {
        user.setRole(user.getRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user).getUsername();
    }

    public JwtTokenResponse authenticate(User clientRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                clientRequest.getUsername(),
                clientRequest.getPassword())
        );
        User user = repository.findByUsername(clientRequest.getUsername());
        String token = jwtTokenService.generateToken(user);
        return new JwtTokenResponse(token);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
