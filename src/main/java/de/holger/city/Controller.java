package de.holger.city;


import de.holger.city.model.CityDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController


@RequestMapping(path="/v1/cities")
public class Controller {

    @RequestMapping( method = RequestMethod.GET)
    List<CityDto> getAllCities() {
        CityDto cityDto = new CityDto();
        cityDto.setCityname("Monheim");
        cityDto.setPopulation(40000L);
        List<CityDto> cities= new ArrayList<>();
        cities.add(cityDto);

        return cities;
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{name}",method = RequestMethod.GET)
    CityDto getCity(@PathVariable String name) {


        CityDto cityDto = new CityDto();
        cityDto.setCityname(name);
        cityDto.setPopulation(40000L);

        return cityDto;
    }



}
