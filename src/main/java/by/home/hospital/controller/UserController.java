package by.home.hospital.controller;

import by.home.hospital.dto.PatientRegisterDto;
import by.home.hospital.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService iUserService;

    @PostMapping(value ="/list/savePatient")
    public ResponseEntity<PatientRegisterDto> addPerson(PatientRegisterDto patientRegisterDto) {
        PatientRegisterDto newPatientRegisterDto = iUserService.saveUserFromPatientRegisterDto(patientRegisterDto);
        return new ResponseEntity<>(newPatientRegisterDto, HttpStatus.CREATED);
    }
}
