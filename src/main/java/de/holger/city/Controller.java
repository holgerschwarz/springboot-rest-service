package de.holger.city;


import de.holger.city.model.CityDto;
import de.holger.city.services.ServicesCities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/cities")
public class Controller {
//
    @Autowired
    private ServicesCities servicesCities;

    @RequestMapping(method = RequestMethod.GET)
    List<CityDto> getAllCities() {
        return servicesCities.getAllCities();
    }


    @RequestMapping(path = "/{cityname}", method = RequestMethod.GET)
    ResponseEntity<?> getCity(@PathVariable String cityname) {
        CityDto cityDto = servicesCities.getCity(cityname);
        if (cityDto == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cityDto);
        }
    }


}
