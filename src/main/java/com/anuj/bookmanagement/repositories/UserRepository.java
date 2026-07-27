package com.anuj.bookmanagement.repositories;

import com.anuj.bookmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
