package ru.kihaev.citydistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kihaev.citydistance.entity.Distance;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
