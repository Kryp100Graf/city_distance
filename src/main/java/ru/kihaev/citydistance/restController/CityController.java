package ru.kihaev.citydistance.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kihaev.citydistance.entity.City;
import ru.kihaev.citydistance.repo.CityRepository;

import java.util.List;

@RestController
public class CityController {

    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/city/all")
    public List<City> allCities() {
        return cityRepository.findAll();
    }
}
