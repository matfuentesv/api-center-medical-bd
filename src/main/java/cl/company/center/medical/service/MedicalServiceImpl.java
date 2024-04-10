package cl.company.center.medical.service;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MedicalServiceImpl implements MedicalService {


    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }
}
