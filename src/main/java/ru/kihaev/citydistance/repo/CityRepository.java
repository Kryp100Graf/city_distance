package ru.kihaev.citydistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kihaev.citydistance.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
