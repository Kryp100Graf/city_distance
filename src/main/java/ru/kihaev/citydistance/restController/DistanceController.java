package ru.kihaev.citydistance.restController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.kihaev.citydistance.entity.City;
import ru.kihaev.citydistance.entity.Distance;
import ru.kihaev.citydistance.repo.CityRepository;
import ru.kihaev.citydistance.repo.DistanceRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DistanceController {

    private DistanceRepository distanceRepository;
    private CityRepository cityRepository;

    @Autowired
    public DistanceController(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    @GetMapping("/distance/all")
    public List<Distance> allDistance() {
        return distanceRepository.findAll();
    }

    @PostMapping("/distance/save")
    public void uploadXML(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                String xmlString = new String(file.getBytes());
                XmlMapper xmlMapper = new XmlMapper();

                ArrayList<Distance> distances = (ArrayList<Distance>) xmlMapper.readValue(xmlString, new TypeReference<List<Distance>>() {});
                distanceRepository.saveAll(distances);
//                for (Distance distance : distances) {
//
//                    cityRepository.getById(distance.getFromCity().getId());
//
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}