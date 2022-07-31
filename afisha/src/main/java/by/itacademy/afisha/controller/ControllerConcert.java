package by.itacademy.afisha.controller;

import by.itacademy.afisha.service.api.IConcertService;
import by.itacademy.afisha.service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TimeZone;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/afisha/event/concerts")
public class ControllerConcert {
    private final IConcertService service;

    public ControllerConcert(IConcertService service) {
        this.service = service;
    }


    @PostMapping
//    @RequestMapping(method = RequestMethod.POST) //аналог @PostMapping
    public ResponseEntity<ConcertCreateDto> create(@RequestBody ConcertCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    //FILMS?page=1&size=20'
    public ResponseEntity<PageDto> getAll(@RequestParam(name = "size", defaultValue = "5") int size,
                                          @RequestParam(name = "page", defaultValue = "1") int page){
        return ResponseEntity.ok(service.getAll(page,size));

    }

    @GetMapping("/{uuid}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //аналог @GetMapping
    public ResponseEntity<ConcertReadDto> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<ConcertCreateDto> update (@RequestBody ConcertCreateDto dto,
                                                 @PathVariable UUID uuid,
                                                 @PathVariable(name = "dt_update") Long dtUpdate){
        return ResponseEntity.ok(service.update(dto,uuid,dtUpdate));
    }
}
