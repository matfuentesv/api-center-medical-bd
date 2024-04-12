package cl.company.center.medical.controller;

import cl.company.center.medical.exception.ErrorResponse;
import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.Patient;
import cl.company.center.medical.service.LoginService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CenterMedicalController {

    private static final Logger log = LoggerFactory.getLogger(CenterMedicalController.class);

    @Autowired
    LoginService loginService;


    // Endpoint que busca el historial medico de un paciente por su run
    @GetMapping("/findHistoryPatientByRun/{run}")
    public ResponseEntity<Object> findHistoryPatientByRun(@PathVariable String run,
                                                          @RequestHeader(value = "user",required = false) String user,
                                                          @RequestHeader(value = "password",required = false) String password) {

        if(StringUtils.containsWhitespace(run) || (user == null || password == null) || (user.isEmpty() || password.isEmpty())) {
            log.error("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(loginService.getHistoryPatientByRun(user,password,run));
    }

    // Endpoint que busca todos los medicos
    @GetMapping("/findAllDoctor")
    public ResponseEntity<Object> findAllDoctor(@RequestHeader(value = "user",required = false) String user,
                                                @RequestHeader(value = "password",required = false) String password) {
        if ((user == null || password == null) || (user.isEmpty() || password.isEmpty())) {
            log.error("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(loginService.findAllDoctor(user,password));
    }

    // Endpoint que busca un medico por su nombre
    @GetMapping("/findDoctor/{name}")
    public ResponseEntity<Object> findDoctor(@PathVariable String name,
                                             @RequestHeader("user") String user,
                                             @RequestHeader("password") String password) {

        if (StringUtils.containsWhitespace(name) ||(user == null || password == null)|| user.isEmpty() || password.isEmpty()) {
            log.error("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(loginService.findDoctor(user,password,name));
    }

    //Crea un nuevo doctor
    @PostMapping("/createDoctor")
    public ResponseEntity<Object> createStudent(@Valid @RequestBody Doctor doctor,
                                                @RequestHeader("user") String user,
                                                @RequestHeader("password") String password) {

        return ResponseEntity.ok(loginService.createDoctor(user,password,doctor));
    }

    //Actualiza un doctor
    @PutMapping("/updateDoctor/{id}")
    public ResponseEntity<Object> updateDoctor(@PathVariable Long id,
                                               @RequestHeader("user") String user,
                                               @RequestHeader("password") String password,
                                               @RequestBody Doctor doctor) {
        return ResponseEntity.ok(loginService.updateDoctor(user,password,id,doctor));
    }

    //Elimina un doctor
    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable Long id,
                                               @RequestHeader("user") String user,
                                               @RequestHeader("password") String password) {
        return ResponseEntity.ok(loginService.deleteDoctor(user, password, id));
    }

    // Endpoint que busca todos los medicos
    @GetMapping("/findAllPatient")
    public ResponseEntity<Object> findAllPatient(@RequestHeader("user") String user,
                                                 @RequestHeader("password") String password) {
        if (user.isEmpty() || password.isEmpty()) {
            log.error("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(loginService.findAllPatient(user,password));
    }

    @GetMapping("/findPatientByRun/{run}")
    public ResponseEntity<Object>findPatienteByRun(@PathVariable String run,
                                             @RequestHeader("user") String user,
                                             @RequestHeader("password") String password) {

        if (StringUtils.containsWhitespace(run) || user.isEmpty() || password.isEmpty()) {
            log.error("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(loginService.findPatientByRun(user,password,run));
    }

    //Crea un nuevo paciente
    @PostMapping("/createPatient")
    public ResponseEntity<Object>createPatient(@Valid @RequestBody Patient patient,
                                               @RequestHeader("user") String user,
                                               @RequestHeader("password") String password) {
        return ResponseEntity.ok(loginService.createPatient(user,password,patient));
    }

    //Actualiza un paciente
    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<Object> updatePatient(@PathVariable Long id,
                                                @RequestHeader("user") String user,
                                                @RequestHeader("password") String password,
                                                @RequestBody Patient patient) {
        return ResponseEntity.ok(loginService.updatePatient(user,password,id,patient));
    }

    //Elimina un paciente
    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id,
                                                @RequestHeader("user") String user,
                                                @RequestHeader("password") String password) {
        return ResponseEntity.ok(loginService.deletePatient(user, password, id));
    }


}
