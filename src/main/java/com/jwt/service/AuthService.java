package com.jwt.service;


import com.jwt.dto.Login;

public interface AuthService {
    String login(Login login);
}