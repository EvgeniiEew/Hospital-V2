package by.home.hospital.controller;

import by.home.hospital.dto.DoctorInfoDto;
import by.home.hospital.dto.DoctorRegisterDto;
import by.home.hospital.service.IDoctorDitalesService;
import by.home.hospital.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController {
    private final IDoctorDitalesService iDoctorDitalesService;
    private final IUserService iUserService;

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorInfoDto>> getDoctorDetails() {
        List<DoctorInfoDto> doctorInfoDtos = iDoctorDitalesService.getDoctorInfoDto();
        return new ResponseEntity<>(doctorInfoDtos, HttpStatus.OK);
    }

//    @GetMapping("/doctor/create")
//    public  ResponseEntity<D> setDoctor(DoctorRegisterDto doctorRegisterDto, Model model) {
//        if (doctorRegisterDto == null) {
//            doctorRegisterDto = new DoctorRegisterDto();
//        }
//        return new ResponseEntity<>(doctorRegisterDto, HttpStatus.OK);
//    }

    @PostMapping(path = "/doctor/register")
    public ResponseEntity<DoctorRegisterDto> registerDoctor(@Valid DoctorRegisterDto doctorRegisterDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
//                || credentialsService.existsByEmail(doctorRegisterDto.getEmail())) {
            return new ResponseEntity<>(doctorRegisterDto, HttpStatus.OK);
        }
//        if (doctorRegisterDto.getPosition().equals(Position.NURSE)) {
//            iUserService.saveNurse(conversionService.convert(doctorRegisterDto, NurseRegisterDto.class));
//            return new ResponseEntity<>(doctorRegisterDto, HttpStatus.OK);
//        }
        DoctorRegisterDto newDoctorRegisterDto = iDoctorDitalesService.registerDoctor(doctorRegisterDto);
        return new ResponseEntity<>(newDoctorRegisterDto, HttpStatus.CREATED);
    }

}
