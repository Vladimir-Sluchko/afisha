package by.itacademy.afisha.controller;

import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IFilmService;
import by.itacademy.afisha.service.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TimeZone;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/afisha/event/films")
public class ControllerFilms {
    private final IFilmService eventFilmService;

    public ControllerFilms(IFilmService eventFilmService) {
        this.eventFilmService = eventFilmService;
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST) //аналог @PostMapping
    public ResponseEntity<FilmCreateDto> create(@RequestBody FilmCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventFilmService.create(dto));
    }

    @GetMapping
    //FILMS?page=1&size=20'
    public ResponseEntity<PageDto> getAll(@RequestParam(name = "size", defaultValue = "5") int size,
                                          @RequestParam(name = "page", defaultValue = "1") int page){
        return ResponseEntity.ok(eventFilmService.getAll(page,size));

    }

    @GetMapping("/{uuid}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //аналог @GetMapping
    public ResponseEntity<FilmReadDto> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(eventFilmService.get(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<FilmCreateDto> update (@RequestBody FilmCreateDto dto,
                                                 @PathVariable UUID uuid,
                                                 @PathVariable(name = "dt_update") Long dtUpdate){
        return ResponseEntity.ok(eventFilmService.update(dto,uuid,dtUpdate));
    }


}
