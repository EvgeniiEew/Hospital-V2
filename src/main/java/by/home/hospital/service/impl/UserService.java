package by.home.hospital.service.impl;

import by.home.hospital.Enum.Position;
import by.home.hospital.domain.Credential;
import by.home.hospital.domain.User;
import by.home.hospital.dto.PatientRegisterDto;
import by.home.hospital.dto.UserEditDto;
import by.home.hospital.service.ICredentialsService;
import by.home.hospital.service.IUserService;
import by.home.hospital.service.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private final UserJpaRepo userJpaRepo;
    private final ICredentialsService iCredentialsService;

    @Override
    public User getUserById(Integer id) {
        User user = userJpaRepo.getUserById(id);
        if (user == null) {
            log.info("User by Id not found");
            return new User();
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userJpaRepo.findByOrderByFirstNameAsc();
    }

    @Override
    public void deleteUser(Integer id) {
        userJpaRepo.deleteById(id);
    }

    @Override
    public void save(User user) {
        userJpaRepo.save(user);
    }

    @Override
    @Transactional
    public PatientRegisterDto saveUserFromPatientRegisterDto(PatientRegisterDto patientRegisterDto) {
        User user = new User();
        user.setPosition(Position.PATIENT);
        user.setFirstName(patientRegisterDto.getFirstName());
        user.setLastName(patientRegisterDto.getLastName());
        user.setCredentials(iCredentialsService.createCredentialsFromPatientRegisterDto(patientRegisterDto));
        userJpaRepo.save(user);
        return patientRegisterDto;
    }

    public List<UserEditDto> getUsersEditDto() {
        List<User> listUsers = userJpaRepo.findByOrderByFirstNameAsc();
        List<UserEditDto> dtoUsersList = new ArrayList<>();
        listUsers.forEach(user -> {
            Credential credential = user.getCredentials();
            dtoUsersList.add(new UserEditDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    credential.getEmail(),
                    credential.getPassword()
            ));
        });
        return dtoUsersList;
    }
}
