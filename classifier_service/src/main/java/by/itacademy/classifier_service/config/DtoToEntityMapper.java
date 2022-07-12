package by.itacademy.classifier_service.config;


import by.itacademy.classifier_service.service.utils.mapper.CategoryMapper;
import by.itacademy.classifier_service.service.utils.mapper.CountryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoToEntityMapper {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    /*@Bean
    public CategoryMapper categoryMapper(ModelMapper mapper){
        return new CategoryMapper(mapper);
    }*/

    @Bean
    public CountryMapper countryMapper(ModelMapper mapper){
        return new CountryMapper(mapper);
    }

}
