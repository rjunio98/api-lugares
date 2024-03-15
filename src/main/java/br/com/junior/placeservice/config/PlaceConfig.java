package br.com.junior.placeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.junior.placeservice.domain.PlaceRepository;
import br.com.junior.placeservice.domain.PlaceService;

@Configuration
public class PlaceConfig {
    
    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }
}
