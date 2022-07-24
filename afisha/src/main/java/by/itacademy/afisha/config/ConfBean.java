package by.itacademy.afisha.config;

import by.itacademy.afisha.service.utils.CheckUuid;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfBean {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CheckUuid checkUuid(RestTemplate restTemplate){
        return new CheckUuid(restTemplate);
    }

}
