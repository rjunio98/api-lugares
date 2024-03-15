package br.com.junior.placeservice.web;

import br.com.junior.placeservice.api.PlaceResponse;
import br.com.junior.placeservice.domain.Place;

public class PlaceMapper {
    
    public static PlaceResponse fromPlaceToResponse (Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
