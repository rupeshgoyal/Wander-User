package com.wander.userservice.user.service;

import com.wander.userservice.user.model.WanderUserDetails;
import com.wander.userservice.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WanderUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .map(WanderUserDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException("User does not exit for user id: " + username));
    }
}
