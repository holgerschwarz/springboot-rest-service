package de.holger.city.services;

import de.holger.city.model.CityDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServicesCitiesImpl implements ServicesCities {
    @Override
    public List<CityDto> getAllCities() {
        CityDto cityDto = new CityDto();
        cityDto.setCityname("Monheim");
        cityDto.setPopulation(40000L);
        List<CityDto> cities= new ArrayList<>();
        cities.add(cityDto);



        cityDto.setCityname("Langenfeld");
        cityDto.setPopulation(40000L);

        cities.add(cityDto);

        return cities;
    }

    @Override
    public CityDto getCity(String cityname) {
        CityDto cityDto = new CityDto();
        cityDto.setCityname(cityname);
        cityDto.setPopulation(40000L);
        return  cityDto;
    }
}
