package cl.company.center.medical.service.impl;

import cl.company.center.medical.controller.CenterMedicalController;
import cl.company.center.medical.exception.ErrorResponse;
import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.repository.UserRepository;
import cl.company.center.medical.service.LoginService;
import cl.company.center.medical.service.MedicalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MedicalService medicalService;

    @Override
    public ResponseEntity<Object> findAllDoctor(String user, String password) {
        final boolean userValid = userRepository.findByUserPassword(user,password).isPresent();
        if(userValid){
           return ResponseEntity.ok(medicalService.getAllDoctor());
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED.name(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<Object> findDoctor(String user, String password, String name) {
        final boolean userValid = userRepository.findByUserPassword(user,password).isPresent();
        if(userValid){
            return ResponseEntity.ok(medicalService.findDoctorByName(name));
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED.name(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<Object>getHistoryPatientByName(String user, String password, String name) {
        final boolean userValid = userRepository.findByUserPassword(user,password).isPresent();
        if(userValid){
            return ResponseEntity.ok(medicalService.getHistoryPatientByName(name));
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED.name(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<Object> createDoctor(String user, String password, Doctor doctor) {
        final boolean userValid = userRepository.findByUserPassword(user,password).isPresent();
        if(userValid){
            final Doctor createdDoctor = medicalService.createDoctor(doctor);
            if(createdDoctor == null){
                log.error("Algunos de los parámetros no se ingresaron");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
            }else {
                return ResponseEntity.ok(doctor);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED.name(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<Object> updateDoctor(String user, String password, Long id, Doctor doctor) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteDoctor(String user, String password, Long id) {
        return null;
    }
}
