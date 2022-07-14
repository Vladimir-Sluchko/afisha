package by.itacademy.user.controller;

import by.itacademy.user.service.api.IServiceUsers;
import by.itacademy.user.service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IServiceUsers service;

    public UserController(IServiceUsers service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<UserCreatDto> create (@RequestBody UserCreatDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<PageDto> getPage (@RequestParam(name = "page",defaultValue = "1") int page,
                                            @RequestParam(name = "size", defaultValue = "20") int size){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserReadDto> get (@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }
    @PutMapping("{uuid}/dt_update/{dt_update}")
    public ResponseEntity<UserCreatDto> update (@RequestBody UserCreatDto dto,
                                                @PathVariable UUID uuid,
                                                @PathVariable(name = "dt_update") Long dtUpdate){
        return ResponseEntity.ok(service.update(dto,uuid,dtUpdate));
    }
    @PostMapping("/registration")
    public ResponseEntity<RegistrationDto> registration (@RequestBody RegistrationDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registration(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserDto> login (@RequestBody LoginUserDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.login(dto);
    }

    public ResponseEntity<UserReadDto> infoMe (@PQ){
        return ResponseEntity.ok(service.get(uu))
    }

}
