package by.itacademy.classifier_service.controllers;

import by.itacademy.classifier_service.service.api.ICountryService;
import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.TimeZone;
import java.util.UUID;

@Controller
@RequestMapping("/classifier")
public class ControllerCountry {
    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    private final ICountryService service;

    public ControllerCountry(ICountryService service) {
        this.service = service;
    }

    @PostMapping("/country")
    public ResponseEntity<CountryCreateDto> create (@Valid @RequestBody CountryCreateDto dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/test2")
    public String test2(@NotBlank(message = "имя не может быть пустым") @Length(min = 2, max = 10, message = "имя должно быть между {min} - {max}") String name) {
        return "success";
    }

    @GetMapping("/country")
    public ResponseEntity<PageDto> get (@RequestParam(name = "page", defaultValue = "1") int page,
                                        @RequestParam(name = "size",defaultValue = "20") int size){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/country/{uuid}")
    public ResponseEntity<UUID> сheckUuid (@PathVariable UUID uuid){
        if (this.service.сheckUuid(uuid)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
