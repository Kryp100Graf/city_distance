package ru.kihaev.citydistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kihaev.citydistance.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
