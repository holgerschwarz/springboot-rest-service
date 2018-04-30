package de.holger.city.services;

import de.holger.city.model.CityDto;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Profile("TEST_STUB")

public class ServicesCitiesStub implements ServicesCities {

    private List<CityDto> cities= new ArrayList<>();

    @PostConstruct
    public void init(){
        CityDto cityDto = new CityDto();
        cityDto.setCityname("abcTest");
        cityDto.setPopulation(40000L);
        cities.add(cityDto);

        cityDto = new CityDto();
        cityDto.setCityname("zxyTest");
        cityDto.setPopulation(40000L);

        cities.add(cityDto);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cities;
    }

    @Override
    public CityDto getCity(String cityname) {
         Optional<CityDto> cityDto = cities.stream().filter(c -> c.getCityname().equalsIgnoreCase(cityname)).findFirst();
         return  (cityDto.isPresent() ?  cityDto.get() :  null);
    }
}
