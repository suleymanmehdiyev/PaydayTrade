package com.example.paydaytradeproject.repository;

import com.example.paydaytradeproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
