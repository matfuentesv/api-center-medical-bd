package cl.company.center.medical.service;

import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<Object>findAllDoctor(String user,String password);
    ResponseEntity<Object>findDoctor(String user,String password,String name);
    ResponseEntity<Object>getHistoryPatientByName(String user,String password,String name);

}
