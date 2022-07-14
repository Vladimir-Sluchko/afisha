package by.itacademy.afisha.service;

import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;
import java.sql.ClientInfoStatus;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:8081/classifier/country";
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);

    }
}
