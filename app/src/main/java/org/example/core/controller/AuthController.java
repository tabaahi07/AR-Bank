package org.example.core.controller;
import org.example.commons.CustomerLoginRequest;
import org.example.commons.CustomerLoginResponse;
import org.example.core.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService ;

    @PostMapping(value = "/login")
    public CustomerLoginResponse customerLogin(@RequestBody CustomerLoginRequest request) {
        return CustomerLoginResponse.builder()
                .accessToken(authService.login(request.getUserId(), request.getPasswd()))
                .build();
    }
}


