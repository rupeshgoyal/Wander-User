package com.wander.userservice.user.mapper;

import com.wander.userservice.user.dto.CreateUserDto;
import com.wander.userservice.user.dto.ResponseUserDto;
import com.wander.userservice.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User getUserFromCreateUserDto(CreateUserDto userDto);
    ResponseUserDto getResponseUserDtoFromUser(User user);
}
