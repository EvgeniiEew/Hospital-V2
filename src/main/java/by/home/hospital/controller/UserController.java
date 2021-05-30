package by.home.hospital.controller;

import by.home.hospital.dto.PatientRegisterDto;
import by.home.hospital.dto.UserEditDto;
import by.home.hospital.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService iUserService;

    @GetMapping(value = "/list/user")
    public ResponseEntity<List<UserEditDto>> getPersons() {
        List<UserEditDto> userEditDtoList = iUserService.getUsersEditDto();
        if (userEditDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userEditDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "/list/savePatient")
    public ResponseEntity<PatientRegisterDto> addPerson(@RequestBody PatientRegisterDto patientRegisterDto) {
        PatientRegisterDto newPatientRegisterDto = iUserService.saveUserFromPatientRegisterDto(patientRegisterDto);
        return new ResponseEntity<>(newPatientRegisterDto, HttpStatus.CREATED);
    }
}
