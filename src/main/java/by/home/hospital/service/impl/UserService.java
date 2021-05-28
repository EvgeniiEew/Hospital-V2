package by.home.hospital.service.impl;

import by.home.hospital.domain.User;
import by.home.hospital.service.IUserService;
import by.home.hospital.service.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserJpaRepo userJpaRepo;

    public User getUserById(Integer id) {
        return userJpaRepo.getUserById(id);
    }
}
