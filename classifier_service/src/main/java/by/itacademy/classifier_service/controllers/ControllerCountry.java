package by.itacademy.classifier_service.controllers;

import by.itacademy.classifier_service.service.api.ICountryService;
import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.TimeZone;

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
    public ResponseEntity<CountryCreateDto> create (@RequestBody CountryCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/country")
    public ResponseEntity<PageDto> get (@RequestParam(name = "page", defaultValue = "1") int page,
                                        @RequestParam(name = "size",defaultValue = "20") int size){
        return ResponseEntity.ok(service.getAll(page,size));
    }
}
