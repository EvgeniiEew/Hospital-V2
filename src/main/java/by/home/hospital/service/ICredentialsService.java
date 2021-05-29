package by.home.hospital.service;

import by.home.hospital.domain.Credential;
import by.home.hospital.dto.PatientRegisterDto;

public interface ICredentialsService {
    Credential createCredentialsFromPatientRegisterDto(PatientRegisterDto patientRegisterDto);
}
