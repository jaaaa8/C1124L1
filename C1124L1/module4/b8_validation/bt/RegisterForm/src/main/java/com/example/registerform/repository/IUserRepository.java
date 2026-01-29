package com.example.registerform.repository;

import com.example.registerform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
