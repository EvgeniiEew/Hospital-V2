package by.home.hospital.service;

import by.home.hospital.domain.User;
import by.home.hospital.dto.PatientRegisterDto;
import by.home.hospital.dto.UserEditDto;

import java.util.List;

public interface IUserService {
    List<UserEditDto> getUsersEditDto();

    User getUserById(Integer id);

    List<User> getUsers();

    void deleteUser(Integer id);

    void save(User user);

    PatientRegisterDto saveUserFromPatientRegisterDto(PatientRegisterDto patientRegisterDto);
}
