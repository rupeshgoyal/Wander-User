package com.wander.userservice.user.repository;

import com.wander.userservice.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUuid(String uuid);
    Optional<User> findByUsername(String username);
}
