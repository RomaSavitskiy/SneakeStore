package com.example.demo.service;

import com.example.demo.DTO.AuthRequest;
import com.example.demo.DTO.UserDto;
import com.example.demo.convertor.UserConvertor;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserConvertor userConvertor;
    private final JwtTokenUtil jwtTokenUtil;


    public void save(AuthRequest authRequest) {
        UserDto userDto = new UserDto();
        userDto.setRoleId(1L);
        userDto.setLogin(authRequest.getLogin());
        userDto.setPassword(authRequest.getPassword());
        save(userDto);
    }

    @Transactional
    public UserDto save(UserDto userDto) {
        Long roleId = userDto.getRoleId();
        Role role = roleRepository.findById(roleId).orElseThrow();

        User user = userConvertor.convert(userDto);

        user.setRole(role);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);

        return userConvertor.convert(user);
    }

    // Фу-фу-фу, так не писать
    public Optional<User> findByLogin (String login) {
        return userRepository.findByLogin(login);
    }

    public Optional<User> findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login).orElseThrow();

        if (passwordEncoder.matches(password, user.getPassword())) {
            return Optional.of(user);
        }

        return null;
    }

    public User getTokenForUserIfExists(AuthRequest authRequest) {
        return findByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword())
                .orElseThrow();
       /* return jwtTokenUtil.generateToken(user.getLogin());*/
    }
}
