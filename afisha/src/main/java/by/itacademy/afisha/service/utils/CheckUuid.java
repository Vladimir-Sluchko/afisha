package by.itacademy.afisha.service.utils;

import by.itacademy.afisha.dao.entity.Event;
import by.itacademy.afisha.service.dto.FilmCreateDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.UUID;

public class CheckUuid {
    private final String url = "http://localhost:8081/classifier/";

    private final RestTemplate restTemplate;



    @Value("${url.urlClassifierCountry}")
    private String urlClassifierCountry;

    @Value("${url.urlClassifierCategory}")
    private String urlClassifierCategory;

    public CheckUuid(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public boolean isCheckUuid(UUID uuid, String nameClassifier){
        String url = "";
        if(nameClassifier.equals("country")){
            url = this.urlClassifierCountry;
        }
        if(nameClassifier.equals("category")){
            url = this.urlClassifierCategory;
        }

        ResponseEntity<Object> forEntity = restTemplate.getForEntity(url + uuid, Object.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        if(statusCode == HttpStatus.OK){
            return true;
        } else {
            return false;
        }
    }
}
