package com.example.mindbalance.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponseLogin> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register/admin")
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerAdmin(request));
    }

    @PostMapping(value = "register/student")
    public ResponseEntity<AuthResponse> registerStudent(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerStudent(request));
    }

    @PostMapping(value = "register/teacher")
    public ResponseEntity<AuthResponse> registerTeacher(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerTeacher(request));
    }

    @PostMapping(value = "register/father")
    public ResponseEntity<AuthResponse> registerFather(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.registerFather(request));
    }

    @DeleteMapping(value= "/users/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        authService.deleteById(userId);
    }
}
