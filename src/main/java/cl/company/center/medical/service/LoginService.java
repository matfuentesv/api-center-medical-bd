package cl.company.center.medical.service;

import cl.company.center.medical.model.Doctor;
import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<Object>findAllDoctor(String user,String password);
    ResponseEntity<Object>findDoctor(String user,String password,String name);
    ResponseEntity<Object>getHistoryPatientByRun(String user,String password,String name);
    ResponseEntity<Object> createDoctor(String user,String password,Doctor doctor);
    ResponseEntity<Object> updateDoctor(String user,String password,Long id,Doctor doctor);
    ResponseEntity<Object> deleteDoctor(String user,String password,Long id);

}
