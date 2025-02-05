package com.backendchallenge.traceabilityservice.application.jwt;

import com.backendchallenge.traceabilityservice.domain.until.ConstExceptions;
import com.backendchallenge.traceabilityservice.domain.until.ConstJwt;
import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class JwtServiceTest {

    @InjectMocks
    private JwtService jwtService;

    @Mock
    private Key key;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        jwtService = spy(new JwtService());
        doReturn(key).when(jwtService).generateKey();
    }

    @Test
    void extractUsername_validJwt_returnsUsername() {
        String jwt = ConstTest.VALID_TOKEN;
        Claims claims = mock(Claims.class);
        when(claims.getSubject()).thenReturn(ConstTest.USERNAME);
        doReturn(claims).when(jwtService).extractAllClaims(jwt);

        String result = jwtService.extractUsername(jwt);

        assertEquals(ConstTest.USERNAME, result);
    }

    @Test
    void extractRole_validJwt_returnsRole() {
        String jwt = ConstTest.VALID_TOKEN;
        Claims claims = mock(Claims.class);
        when(claims.get(ConstJwt.ROLE)).thenReturn(ConstTest.ROLE);
        doReturn(claims).when(jwtService).extractAllClaims(jwt);

        String result = jwtService.extractRole(jwt);

        assertEquals(ConstTest.ROLE, result);
    }

    @Test
    void extractId_validJwt_returnsId() {
        String jwt = ConstTest.VALID_TOKEN;
        Claims claims = mock(Claims.class);
        when(claims.get(ConstJwt.ID)).thenReturn(ConstTest.ID_TEST);
        doReturn(claims).when(jwtService).extractAllClaims(jwt);

        Long result = jwtService.extractId(jwt);

        assertEquals(ConstTest.ID_TEST, result);
    }

    @Test
    void extractUsername_invalidJwt_throwsException() {
        String jwt = ConstTest.INVALID_TOKEN;
        doThrow(new IllegalArgumentException(ConstExceptions.INVALID_TOKEN)).when(jwtService).extractAllClaims(jwt);

        assertThrows(IllegalArgumentException.class, () -> jwtService.extractUsername(jwt));
    }

    @Test
    void extractRole_invalidJwt_throwsException() {
        String jwt = ConstTest.INVALID_TOKEN;
        doThrow(new IllegalArgumentException(ConstExceptions.INVALID_TOKEN)).when(jwtService).extractAllClaims(jwt);

        assertThrows(IllegalArgumentException.class, () -> jwtService.extractRole(jwt));
    }

    @Test
    void extractId_invalidJwt_throwsException() {
        String jwt = ConstTest.INVALID_TOKEN;
        doThrow(new IllegalArgumentException(ConstExceptions.INVALID_TOKEN)).when(jwtService).extractAllClaims(jwt);

        assertThrows(IllegalArgumentException.class, () -> jwtService.extractId(jwt));
    }
}