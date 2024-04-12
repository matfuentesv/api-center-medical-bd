package cl.company.center.medical.service.impl;

import cl.company.center.medical.controller.CenterMedicalController;
import cl.company.center.medical.exception.ErrorResponse;
import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.repository.MedicalRecordRepository;
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
    private MedicalRecordRepository medicalRecordRepository;

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
    public ResponseEntity<Object>getHistoryPatientByRun(String user, String password, String name) {
        final boolean userValid = userRepository.findByUserPassword(user,password).isPresent();
        if(userValid){
            return ResponseEntity.ok(medicalService.getHistoryPatientByRun(name));
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
        final boolean userValid = userRepository.findByUserPassword(user,password).isPresent();
        if(userValid){
            if(medicalService.existsDoctorById(id)){
                doctor.setId(id);
                return ResponseEntity.ok(medicalService.updateDoctor(doctor));
            }   else {
                log.error("No se puedo actualizar el doctor,no existe");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("No se puedo actualizar el doctor,no existe"));
            }
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED.name(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<Object> deleteDoctor(String user, String password, Long id) {

        // Verificar la autenticación del usuario
        boolean userValid = userRepository.findByUserPassword(user, password).isPresent();
        if (!userValid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        // Verificar si el doctor existe
        if (!medicalService.existsDoctorById(id)) {
            log.error("No se puede eliminar el doctor, no existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("El doctor no existe"));
        }

        // Verificar si el doctor tiene registros médicos asociados en la tabla historial(FK)
        if (medicalRecordRepository.findDoctor(id).isPresent()) {
            log.error("No se puede eliminar el doctor, existe en tabla Historial");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("No se puede eliminar el doctor, existe en tabla Historial"));
        }

        // Eliminar al doctor
        medicalService.deleteDoctor(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }

}
