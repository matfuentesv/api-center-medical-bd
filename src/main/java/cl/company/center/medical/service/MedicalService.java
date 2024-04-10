package cl.company.center.medical.service;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.MedicalRecord;
import cl.company.center.medical.model.Patient;

import java.util.List;

public interface MedicalService {

    List<Patient> getAllPatients();
    List<MedicalRecord> getMedicalRecord(String patientName);
    List<Doctor> getAllDoctor();
    Doctor findDoctorByName(String name);


}
