package cl.company.center.medical.service.impl;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.HistoricalMedical;
import cl.company.center.medical.repository.DoctorRepository;
import cl.company.center.medical.repository.MedicalRecordRepository;
import cl.company.center.medical.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class MedicalServiceImpl implements MedicalService {


    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;


    @Override
    public List<HistoricalMedical> getHistoryPatientByName(String name) {
        Predicate<HistoricalMedical> predicate = x-> x.getPaciente().getNombre().equalsIgnoreCase(name);
        return medicalRecordRepository
                               .findAll()
                               .stream()
                               .filter(predicate)
                               .collect(Collectors.toList());
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findDoctorByName(String name) {
        return doctorRepository.findByName(name);
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public boolean existsDoctorById(Long id) {
        return doctorRepository.existsById(id);
    }
}
