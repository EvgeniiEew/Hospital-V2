package by.home.hospital.service;

import by.home.hospital.Enum.Position;
import by.home.hospital.domain.User;
import by.home.hospital.dto.DoctorRegisterDto;
import by.home.hospital.dto.PatientRegisterDto;
import by.home.hospital.dto.UserEditDto;

import java.util.HashSet;
import java.util.List;

public interface IUserService {
    List<UserEditDto> getUsersEditDto();

    User getUserById(Integer id);

    User saveUserFromDoctorRegisterDto(DoctorRegisterDto doctorRegisterDto);

    List<User> getUsers();

    HashSet<User> findAllByPositionOrderByFirstNameDesc(Position position);

    void deleteUser(Integer id);

    void save(User user);

    PatientRegisterDto saveUserFromPatientRegisterDto(PatientRegisterDto patientRegisterDto);
}
