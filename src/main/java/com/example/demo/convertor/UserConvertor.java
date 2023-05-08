package com.example.demo.convertor;

import com.example.demo.DTO.UserDto;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    public User convert(UserDto userDto) {
        User user = new User();

        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public UserDto convert(User user) {
        UserDto userDto = new UserDto();

        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRoleId(user.getId());

        return userDto;
    }
}
