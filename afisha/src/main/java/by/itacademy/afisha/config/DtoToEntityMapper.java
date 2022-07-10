package by.itacademy.afisha.config;

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

}
