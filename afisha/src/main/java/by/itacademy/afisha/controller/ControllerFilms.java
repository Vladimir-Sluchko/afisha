package by.itacademy.afisha.controller;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmCreateDto;
import by.itacademy.afisha.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IFilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TimeZone;
import java.util.UUID;

@RestController
@RequestMapping("/film")
public class ControllerFilms {
    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    private final IFilmService eventFilmService;

    public ControllerFilms(IFilmService eventFilmService) {
        this.eventFilmService = eventFilmService;
    }

    @PostMapping("/{type}")
//    @RequestMapping(method = RequestMethod.POST) //аналог @PostMapping
    public ResponseEntity<FilmCreateDto> create(@RequestBody FilmCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventFilmService.create(dto));
    }

    @GetMapping("/{type}/{uuid}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //аналог @GetMapping
    public ResponseEntity<FilmReadDto> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(eventFilmService.get(uuid));
    }

}
