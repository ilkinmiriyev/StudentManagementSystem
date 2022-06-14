package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.LoginRequest;
import edu.deegrework.StudentManagementSystem.response.CustomUserDetailsResponse;
import edu.deegrework.StudentManagementSystem.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/login")
@CrossOrigin
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final LoginService loginService;

    @PostMapping
    public CustomUserDetailsResponse login(@RequestBody LoginRequest user){
        log.info("ActionLog.Login.start");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return loginService.successLogin();
    }
}
