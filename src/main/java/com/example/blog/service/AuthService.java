package com.example.blog.service;

import com.example.blog.dto.AuthRequest;
import com.example.blog.dto.AuthResponse;
import com.example.blog.model.BlogUser;
import com.example.blog.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public void register(AuthRequest authRequest) {
        BlogUser blogUser = new BlogUser();
        blogUser.setUsername(authRequest.getUsername());
        blogUser.setPassword(authRequest.getPassword());
        authRepository.save(blogUser);
    }

    public AuthResponse login(AuthRequest authRequest) {
        BlogUser user = authRepository.findByUsername(authRequest.getUsername()).get();
        return new AuthResponse(user.getUsername(), user.isAdmin());

    }
}
