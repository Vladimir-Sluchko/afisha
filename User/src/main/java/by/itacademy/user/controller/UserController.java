package by.itacademy.user.controller;

import by.itacademy.user.controller.utils.JwtTokenUtil;
import by.itacademy.user.dao.entity.User;
import by.itacademy.user.service.UserService;
import by.itacademy.user.service.componets.UserHolder;
import by.itacademy.user.service.dto.LoginUserDto;
import by.itacademy.user.service.dto.RegistrationDto;
import by.itacademy.user.service.dto.UserReadDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final UserHolder holder;

    public UserController(UserService service, UserHolder holder) {
        this.service = service;
        this.holder = holder;
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

    @GetMapping("/me")
    public ResponseEntity<UserReadDto>  infoForMe(){
        UserDetails user = holder.getUser();
        return ResponseEntity.ok().body(service.infoForMe(user.getUsername()));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("ok");
    }


}
