package org.raoamigos.springsecurity2.repository;

import org.raoamigos.springsecurity2.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
