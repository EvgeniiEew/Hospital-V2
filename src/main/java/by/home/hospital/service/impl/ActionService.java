package by.home.hospital.service.impl;

import by.home.hospital.service.IActionService;
import by.home.hospital.service.repository.ActionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionService implements IActionService {
    private final ActionJpaRepository actionJpaRepository;
}
