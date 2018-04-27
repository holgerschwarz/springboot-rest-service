package de.holger.city.services;

import de.holger.city.model.CityDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServicesCities  {

     List<CityDto> getAllCities ();

     CityDto getCity (String cityname);


}
