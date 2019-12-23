package com.netcracker.gorbunov.fapi.controller.authentication;

import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.models.UserViewModel;
import com.netcracker.gorbunov.fapi.models.authentication.AuthToken;
import com.netcracker.gorbunov.fapi.models.authentication.LoginUser;
import com.netcracker.gorbunov.fapi.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//AuthenticationController has API exposed to generate JWT token
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity register(@Valid @RequestBody LoginUser userModel){



        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userModel.getUsername(),
                        userModel.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
}
