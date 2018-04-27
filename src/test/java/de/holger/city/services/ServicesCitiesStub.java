package de.holger.city.services;

import de.holger.city.model.CityDto;
import org.junit.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServicesCitiesStub implements ServicesCities {

    private List<CityDto> cities= new ArrayList<>();

    @Before
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
        return cities.stream().filter(c -> c.getCityname().equalsIgnoreCase(cityname)).findFirst().get();
    }
}
