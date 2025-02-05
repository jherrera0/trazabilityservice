package com.backendchallenge.traceabilityservice.application.jwt;


import com.backendchallenge.traceabilityservice.domain.until.ConstExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String jwt) throws UsernameNotFoundException {
        if (jwt == null || jwt.isBlank()) {
            throw new UsernameNotFoundException(ConstExceptions.USER_NOT_FOUND);
        }
        String username = jwtService.extractUsername(jwt);
        String role = jwtService.extractRole(jwt);
        Collection<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(role)
        );

        return new User(username, "", authorities);
    }
}