package com.wander.userservice.user.service;

import com.wander.userservice.user.dto.CreateUserDto;
import com.wander.userservice.user.dto.ResponseUserDto;

public interface UserService {
    void saveUser(CreateUserDto userDto);

    ResponseUserDto getUserByUuid(String uuid);

    ResponseUserDto getUserByUsername(String username);
}
