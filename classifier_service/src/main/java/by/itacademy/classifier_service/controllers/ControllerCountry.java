package by.itacademy.classifier_service.controllers;

import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/classifier")
public class ControllerCountry {

    @PostMapping("/country")
    public ResponseEntity<CountryCreateDto> create (@RequestBody CountryReadDto country){
        return null;//ResponseEntity.status(HttpStatus.CREATED).body();
    }
}
