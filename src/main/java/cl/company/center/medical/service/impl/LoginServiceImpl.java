package cl.company.center.medical.service.impl;

import cl.company.center.medical.repository.UserRepository;
import cl.company.center.medical.service.LoginService;
import cl.company.center.medical.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

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
}
