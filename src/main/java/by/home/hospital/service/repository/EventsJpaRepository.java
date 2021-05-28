package by.home.hospital.service.repository;

import by.home.hospital.domain.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsJpaRepository extends JpaRepository<Events, Integer> {
}
