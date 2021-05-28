package by.home.hospital.service.repository;

import by.home.hospital.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<Event, Integer> {
}
