package com.example.bookmyshow.respository;

import com.example.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Long> {

    Optional<User> findById(Long aLong);
}
