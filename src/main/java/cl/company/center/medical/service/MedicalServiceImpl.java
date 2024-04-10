package cl.company.center.medical.service;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.MedicalRecord;
import cl.company.center.medical.model.Patient;
import cl.company.center.medical.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalServiceImpl implements MedicalService {


    @Autowired
    private MedicalRepository medicalRepository;


    // Obtiene el total de pacientes
    @Override
    public List<Patient> getAllPatients() {
        return medicalRepository.dataSource();

    }

    // Obtiene el historial de un paciente,filtrado por su nombre
    @Override
    public List<MedicalRecord> getMedicalRecord(String patientName) {

        return medicalRepository.dataSource()
                .stream()
                .filter(record -> record.getName().equalsIgnoreCase(patientName))
                .flatMap(patient -> patient.getMedicalRecords().stream())
                .collect(Collectors.toList());
    }

    // Obtiene el listado completo de doctores
    @Override
    public List<Doctor> getAllDoctor() {
        return medicalRepository.dataSource()
                .stream()
                .flatMap(patient -> patient.getMedicalRecords().stream())
                .map(MedicalRecord::getDoctor)
                .collect(Collectors.toList());
    }

    // Busca un doctor por su nombre
    @Override
    public Doctor findDoctorByName(String name) {
        return medicalRepository.dataSource()
                .stream()
                .flatMap(patient -> patient.getMedicalRecords().stream())
                .map(MedicalRecord::getDoctor)
                .filter(x->x.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(new Doctor());
    }


}
