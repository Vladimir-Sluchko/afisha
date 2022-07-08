package by.itacademy.afisha.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoToEntinyMapper {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public FilmMapper filmMapper (ModelMapper modelMapper){
        return new FilmMapper(modelMapper);
    }
    @Bean
    public EventFilmsMapper filmsMapper(ModelMapper mapper,WebClient webClient) {
        return new EventFilmsMapper(mapper, webClient);
    }

        @Bean
        public ConcertMapper concertMapper(ModelMapper mapper) {
            return new ConcertMapper(mapper);
        }

        @Bean
        public CountryMapper countryMapper(ModelMapper mapper){
            return new CountryMapper(mapper);
        }

    }
}
