package cl.company.center.medical.service;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.HistoricalMedical;
import cl.company.center.medical.model.Patient;

import java.util.List;
import java.util.Optional;

public interface MedicalService {


    List<HistoricalMedical> getHistoryPatientByRun(String run);
    List<Doctor> getAllDoctor();
    Optional<Doctor> findDoctorByName(String name);
    Doctor createDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(Long id);
    boolean existsDoctorById(Long id);
    List<Patient> getAllPatient();
    Optional<Patient> findPatientByRun(String run);
    Patient createPatient(Patient patient);
    Patient updatePatient(Patient patient);
    boolean existsPatientById(Long id);
    void deletePatient(Long id);

}
