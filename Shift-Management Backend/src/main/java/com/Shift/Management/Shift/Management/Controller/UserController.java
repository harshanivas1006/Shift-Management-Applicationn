//import com.Shift.Management.Shift.Management.Dto.UserDto;
//import com.Shift.Management.Shift.Management.Services.UserImplementation;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class UserController {
//
//    @Autowired
//    private UserImplementation userImplementation;
//
////    @PostMapping("/register")
////    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
////        userImplementation.registerNewUser(userDto);
////        return ResponseEntity.ok("User registered successfully");
////    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
//        System.out.println("Username: " + userDto.getUsername());
//        System.out.println("Password: " + userDto.getPassword());
//
////        return ResponseEntity.ok("User registered successfully");
//
//        return ResponseEntity.ok("User registered successfully");
//    }
//}
//

package com.Shift.Management.Shift.Management.Controller;

import com.Shift.Management.Shift.Management.Dto.UserDto;

import com.Shift.Management.Shift.Management.Services.JwtService;
import com.Shift.Management.Shift.Management.Services.UserService;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        System.out.println("Username: " + userDto.getUsername());
        System.out.println("Password: " + userDto.getPassword());

        if (userDto.getUsername() == null || userDto.getPassword() == null) {
            return ResponseEntity.badRequest().body("Missing username or password");
        }

        return ResponseEntity.ok("User registered successfully");
    }

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserDto userDto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword())
        );
        String jwtToken = jwtService.generateToken(auth.getName());
        return ResponseEntity.ok(new AuthResponse(jwtToken));
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
