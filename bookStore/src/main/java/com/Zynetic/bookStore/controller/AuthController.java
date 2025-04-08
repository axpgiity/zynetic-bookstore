package com.Zynetic.bookStore.controller;

import com.Zynetic.bookStore.dto.JwtResponse;
import com.Zynetic.bookStore.dto.UserRequest;
import com.Zynetic.bookStore.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserRequest request){
        String message = authService.register(request);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login (@RequestBody UserRequest request) {
        try{
         JwtResponse token = authService.login(request);
         return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
