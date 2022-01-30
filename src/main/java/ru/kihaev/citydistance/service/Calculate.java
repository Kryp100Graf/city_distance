package ru.kihaev.citydistance.service;

import org.springframework.stereotype.Service;
import ru.kihaev.citydistance.entity.City;

@Service
public class Calculate {

    private int EARTH_RADIUS = 6371;

    public double crowlying(City cityFrom, City cityTo){

        double latFrom = toRad(cityFrom.getLatitude());
        double lonFrom = toRad(cityFrom.getLongitude());
        double latTo = toRad(cityTo.getLatitude());
        double lonTo = toRad(cityTo.getLongitude());



        return  (EARTH_RADIUS * Math.acos(Math.sin(latFrom) * Math.sin(latTo) + Math.cos(latFrom) *
                        Math.cos(latTo) * Math.cos(lonTo - lonFrom))); // веррни результат этого ментода
    }

    public int deikstra(City cityFrom, City cityTo) {

        return 0;
    }

    private double toRad(double deg) {
        return deg * Math.PI / 180;
    }

    private double toDeg(double rad) {
        return rad * 180 / Math.PI;
    }

}
