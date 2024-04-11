package cl.company.center.medical.controller;

import cl.company.center.medical.repository.model.Paciente;
import cl.company.center.medical.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicalController {

    @Autowired
    private MedicalService medicalService;

    @GetMapping("/getAllPatients")
    public ResponseEntity<List<Paciente>> getAllPatients() {
        return ResponseEntity.ok(medicalService.getAllPatients());
    }



}
