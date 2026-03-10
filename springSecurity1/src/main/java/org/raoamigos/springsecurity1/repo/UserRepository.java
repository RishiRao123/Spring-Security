package org.raoamigos.springsecurity1.repo;

import org.raoamigos.springsecurity1.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);
}
