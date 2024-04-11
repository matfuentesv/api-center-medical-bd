package cl.company.center.medical.service;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.HistoricalMedical;

import java.util.List;
import java.util.Optional;

public interface MedicalService {


    List<HistoricalMedical> getHistoricalMedical(String name);
    List<Doctor> getAllDoctor();
    Optional<Doctor> findDoctorByName(String name);

}
