/*package com.example.demo.service;

import com.example.demo.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import com.example.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return CustomUserDetails.getUserDetailsFromUser(user);
    }
}*/
