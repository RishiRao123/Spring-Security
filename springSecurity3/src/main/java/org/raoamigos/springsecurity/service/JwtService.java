package org.raoamigos.springsecurity.service;

import org.raoamigos.springsecurity.entity.User;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private String secretKey = null;

    public String generateToken(User user) {

    }

    private String getSecretKey() {
        return secretKey = "YHem0NK0rSO0IZ8ExDxmCNV2UhmcQ55hJQN6B87V0TU";
    }
}
