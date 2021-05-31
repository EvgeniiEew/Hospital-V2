package by.home.hospital.service.impl;

import by.home.hospital.domain.Credential;
import by.home.hospital.dto.DoctorRegisterDto;
import by.home.hospital.dto.PatientRegisterDto;
import by.home.hospital.service.ICredentialsService;
import by.home.hospital.service.repository.CredentialsJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialsService implements ICredentialsService {
    private final CredentialsJpaRepository credentialsJpaRepository;

    @Override
    public Credential createCredentialsFromPatientRegisterDto(PatientRegisterDto patientRegisterDto) {
        Credential credentials = new Credential();
        credentials.setEmail(patientRegisterDto.getEmail());
        credentials.setPassword(patientRegisterDto.getPassword());
        return credentialsJpaRepository.save(credentials);
    }

    @Override
    public Credential saveCredentialsFromDoctorRegisterDto(DoctorRegisterDto doctorRegisterDto) {
        Credential credentials = new Credential();
        credentials.setEmail(doctorRegisterDto.getEmail());
        credentials.setPassword(doctorRegisterDto.getPassword());
        return credentialsJpaRepository.save(credentials);
    }
}
