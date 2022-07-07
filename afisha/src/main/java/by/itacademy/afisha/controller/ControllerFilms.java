package by.itacademy.afisha.controller;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmDto;
import by.itacademy.afisha.service.api.IEventFilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TimeZone;

@RestController
@RequestMapping("/film")
public class ControllerFilms {
    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    private final IEventFilmService eventFilmService;

    public ControllerFilms(IEventFilmService eventFilmService) {
        this.eventFilmService = eventFilmService;
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST) //аналог @PostMapping
    public ResponseEntity<Film> create(@RequestBody FilmDto dto){
        return new ResponseEntity<>(this.eventFilmService.create(dto), HttpStatus.CREATED);
    }
    @GetMapping("/{uuid}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //аналог @GetMapping
    public Film get(@PathVariable String uuid){
        return this.eventFilmService.get(uuid);
    }

}
