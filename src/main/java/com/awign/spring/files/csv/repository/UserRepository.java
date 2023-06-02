package com.awign.spring.files.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awign.spring.files.csv.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
