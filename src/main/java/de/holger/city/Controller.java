package de.holger.city;


import de.holger.city.model.CityDto;
import de.holger.city.services.ServicesCities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping(path="/v1/cities")
public class Controller {

    @Autowired
    private ServicesCities servicesCities;

    @RequestMapping( method = RequestMethod.GET)
    List<CityDto> getAllCities() {
        return servicesCities.getAllCities();

    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{name}",method = RequestMethod.GET)
    CityDto getCity(@PathVariable String name) {
        return servicesCities.getCity("Berlin");
    }



}
