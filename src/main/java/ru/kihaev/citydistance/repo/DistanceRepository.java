package ru.kihaev.citydistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kihaev.citydistance.entity.Distance;

public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
