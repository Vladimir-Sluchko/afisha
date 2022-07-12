package by.itacademy.classifier_service.config;

import by.itacademy.afisha.service.utils.mapper.EventConcertMapper;
import by.itacademy.afisha.service.utils.mapper.EventFilmMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoToEntityMapper {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public EventFilmMapper filmMapper(ModelMapper mapper){
        return new EventFilmMapper(mapper);
    }

    @Bean
    public EventConcertMapper concertMapper(ModelMapper mapper){
        return new EventConcertMapper(mapper);
    }

}
