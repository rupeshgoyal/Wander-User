package com.wander.userservice.user.service;

import com.wander.userservice.exception.UserNotFoundException;
import com.wander.userservice.user.dto.CreateUserDto;
import com.wander.userservice.user.dto.ResponseUserDto;
import com.wander.userservice.user.mapper.UserMapper;
import com.wander.userservice.user.model.User;
import com.wander.userservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(CreateUserDto userDto) {
        User user = userMapper.getUserFromCreateUserDto(userDto);
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(true);

        userRepository.save(user);
    }

    @Override
    public ResponseUserDto getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::getResponseUserDtoFromUser)
                .orElseThrow(() -> new UserNotFoundException("User not found for username: " + username));
    }

    @Override
    public ResponseUserDto getUserByUuid(String uuid) {
        return userRepository.findByUuid(uuid)
                .map(userMapper::getResponseUserDtoFromUser)
                .orElseThrow(() -> new UserNotFoundException("User not found for uuid: " + uuid));
    }
}
