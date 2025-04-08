package com.Zynetic.bookStore.service;

import com.Zynetic.bookStore.dto.JwtResponse;
import com.Zynetic.bookStore.dto.UserRequest;
import com.Zynetic.bookStore.model.User;
import com.Zynetic.bookStore.repository.UserRepository;
import com.Zynetic.bookStore.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Zynetic.bookStore.repository.UserRepository;
import com.Zynetic.bookStore.security.JwtUtil;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserRepository userRepo,PasswordEncoder passwordEncoder,JwtUtil jwtUtil) {
        this.userRepo=userRepo;
        this.jwtUtil=jwtUtil;
        this.passwordEncoder=passwordEncoder;
    }

    public String register(UserRequest request){
        User user= new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepo.save(user);
        return "Welcome BROTHERS nd Sisters!";
    }

    public JwtResponse login(UserRequest request)throws Exception{
        User user = userRepo.findByEmail(request.getEmail()).orElse(null);

        if(user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new Exception("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new JwtResponse(token);
    }
}
