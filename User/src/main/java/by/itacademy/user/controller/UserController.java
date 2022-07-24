package by.itacademy.user.controller;

import by.itacademy.user.controller.utils.JwtTokenUtil;
import by.itacademy.user.service.UserService;
import by.itacademy.user.service.UserServiceDetails;
import by.itacademy.user.service.dto.LoginUserDto;
import by.itacademy.user.service.dto.RegistrationDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/registration")
    public ResponseEntity<RegistrationDto> registration (@RequestBody RegistrationDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<String>  login(@RequestBody LoginUserDto dto){
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION,
                JwtTokenUtil.generateAccessToken(service.login(dto)));
        return ResponseEntity.ok().headers(headers).build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("ok");
    }


}
