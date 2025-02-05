package com.backendchallenge.traceabilityservice.application.jwt;

import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import com.backendchallenge.traceabilityservice.domain.until.ConstValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MyUserDetailsServiceTest {

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private MyUserDetailsService myUserDetailsService;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable =  MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsername_validJwt_returnsUserDetails() {
        String jwt = ConstTest.VALID_TOKEN;
        String username = ConstTest.USERNAME;
        String role = ConstTest.ROLE;
        when(jwtService.extractUsername(jwt)).thenReturn(username);
        when(jwtService.extractRole(jwt)).thenReturn(role);

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwt);

        assertEquals(username, userDetails.getUsername());
        assertEquals(ConstValidation.ONE, userDetails.getAuthorities().size());
        assertEquals(role, userDetails.getAuthorities().iterator().next().getAuthority());
    }

    @Test
    void loadUserByUsername_nullJwt_throwsUsernameNotFoundException() {
        assertThrows(UsernameNotFoundException.class, () -> myUserDetailsService.loadUserByUsername(null));
    }

    @Test
    void loadUserByUsername_blankJwt_throwsUsernameNotFoundException() {
        assertThrows(UsernameNotFoundException.class, () -> myUserDetailsService.loadUserByUsername(ConstTest.EMPTY));
    }
}