package by.home.hospital.service.impl;

import by.home.hospital.Enum.Position;
import by.home.hospital.domain.DoctorDetails;
import by.home.hospital.domain.User;
import by.home.hospital.dto.DoctorInfoDto;
import by.home.hospital.dto.DoctorRegisterDto;
import by.home.hospital.service.IDoctorDitalesService;
import by.home.hospital.service.IUserService;
import by.home.hospital.service.repository.DoctorDitalesJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorDetailsService implements IDoctorDitalesService {
    private final DoctorDitalesJpaRepository doctorDitalesJpaRepository;
    private final IUserService iUserService;

    @Override
    public List<DoctorInfoDto> getDoctorInfoDto() {
        HashSet<User> users = iUserService.findAllByPositionOrderByFirstNameDesc(Position.DOCTOR);
        return users.stream().map(user -> new DoctorInfoDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPosition(),
                user.getDoctorDetails().getName()
        )).collect(Collectors.toList());
    }

    @Override
    public DoctorRegisterDto registerDoctor(DoctorRegisterDto doctorRegisterDto) {
        DoctorDetails doctorDetails = new DoctorDetails();
        doctorDetails.setDoctor(iUserService.saveUserFromDoctorRegisterDto(doctorRegisterDto));
        doctorDetails.setName(doctorRegisterDto.getDoctorDitales());
        doctorDitalesJpaRepository.save(doctorDetails);
        return doctorRegisterDto;
    }

    @Override
    public void addDoctorDetails(DoctorDetails doctorDetails) {

    }

    @Override
    public void deleteDoctorDetails(Integer number) {

    }

    @Override
    public void save(DoctorDetails doctorDetails) {

    }
}
