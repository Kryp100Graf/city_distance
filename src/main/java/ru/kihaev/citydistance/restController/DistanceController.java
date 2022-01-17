package ru.kihaev.citydistance.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kihaev.citydistance.entity.Distance;
import ru.kihaev.citydistance.repo.DistanceRepository;

import java.util.List;

@RestController
public class DistanceController {

    private DistanceRepository distanceRepository;

    @Autowired
    public DistanceController(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    @GetMapping("/distance/all")
    public List<Distance> allDistance() {
        return distanceRepository.findAll();
    }
}