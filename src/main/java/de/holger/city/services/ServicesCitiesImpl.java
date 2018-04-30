package de.holger.city.services;

import de.holger.city.model.CityDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("PROD")
public class ServicesCitiesImpl implements ServicesCities {

    private List<CityDto> cities= new ArrayList<>();

    @PostConstruct
    public void init(){
        CityDto cityDto = new CityDto();
        cityDto.setCityname("Monheim");
        cityDto.setPopulation(40000L);
        cities.add(cityDto);

        cityDto = new CityDto();
        cityDto.setCityname("Langenfeld");
        cityDto.setPopulation(40000L);
        cities.add(cityDto);
    }

    @Override
    public List<CityDto> getAllCities() {
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
