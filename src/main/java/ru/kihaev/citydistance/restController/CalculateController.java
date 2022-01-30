package ru.kihaev.citydistance.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kihaev.citydistance.repo.CityRepository;
import ru.kihaev.citydistance.service.Calculate;

@RestController
public class CalculateController {

    @Autowired
    private Calculate calculate;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/calculate/crowflying")
    public double crowFlying(long from, long to) {
        return calculate.crowlying(cityRepository.getById(from),
                cityRepository.getById(to));
    }

    @GetMapping("/calculate/deikstra")
    public long deikstra(long from, long to) {
        return calculate.deikstra(cityRepository.getById(from),
                cityRepository.getById(to));
    }
}
