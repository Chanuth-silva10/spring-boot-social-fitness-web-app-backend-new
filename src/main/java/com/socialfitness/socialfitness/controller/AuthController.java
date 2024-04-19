package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.config.JwtProvider;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.repository.UserRepository;
import com.socialfitness.socialfitness.request.LoginRequest;
import com.socialfitness.socialfitness.response.AuthResponse;
import com.socialfitness.socialfitness.service.CustomerUserDetailsService;
import com.socialfitness.socialfitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception{

        User isExit = userRepository.findByEmail(user.getEmail());

        if(isExit!=null){
            throw new Exception("this email already used with another account");
        }

        User newUser = new User();

        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());

        String token = JwtProvider.generateToken(authentication);

        AuthResponse res = new AuthResponse(token,"User Register Success!");

        return res;
    }

    @PostMapping("/signin")
    public AuthResponse signup(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticate(loginRequest.getEmail(),loginRequest.getPassword());

        String token = JwtProvider.generateToken(authentication);

        AuthResponse res = new AuthResponse(token,"User Login Success!");

        return res;
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(email);

        if(userDetails==null){
            throw new BadCredentialsException("password not matched");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("password not matched!");
        }

        return  new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}
