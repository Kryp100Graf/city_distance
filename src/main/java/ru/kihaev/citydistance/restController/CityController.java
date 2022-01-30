package ru.kihaev.citydistance.restController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.kihaev.citydistance.entity.City;
import ru.kihaev.citydistance.repo.CityRepository;

import java.io.IOException;
import java.util.ArrayList;
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

    @PostMapping("/city/save")
    public void uploadXML(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                String xmlString = new String(file.getBytes());
                XmlMapper xmlMapper = new XmlMapper();
                ArrayList<City> cities = (ArrayList<City>) xmlMapper.readValue(xmlString, new TypeReference<List<City>>() {});
                cityRepository.saveAll(cities);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}