package by.home.hospital.service.repository;

import by.home.hospital.domain.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingDayJpaRepository extends JpaRepository<WorkingDay, Integer> {
}
