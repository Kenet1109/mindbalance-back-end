package com.example.mindbalance.auth;

import com.example.mindbalance.jwt.JwtService;
import com.example.mindbalance.user.Role;
import com.example.mindbalance.user.User;
import com.example.mindbalance.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponseLogin login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponseLogin.builder()
                .token(token)
                .username(request.getUsername())
                .rol(String.valueOf(user.getRole()))
                .build();
    }

    public AuthResponse registerAdmin(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .username(request.getUsername())
                .build();

    }

    public AuthResponse registerStudent(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.STUDENT)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .username(request.getUsername())
                .build();

    }

    public AuthResponse registerTeacher(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.TEACHER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .username(request.getUsername())
                .build();

    }

    public AuthResponse registerFather (RegisterRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.FATHER)
                .build();

        userRepository.save(user);

        return  AuthResponse.builder()
                .username(request.getUsername())
                .build();
    }

    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }
}
