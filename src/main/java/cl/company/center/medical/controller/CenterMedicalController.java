package cl.company.center.medical.controller;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.HistoricalMedical;
import cl.company.center.medical.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CenterMedicalController {

    @Autowired
    private MedicalService medicalService;


    @GetMapping("/historicalMedical/{name}")
    public ResponseEntity<List<HistoricalMedical>> getHistoricalMedical(@PathVariable String name) {
        return ResponseEntity.ok(medicalService.getHistoricalMedical(name));
    }

    @GetMapping("/allMedicalRecords")
    public ResponseEntity<List<Doctor>> getAllMedicalRecords() {
        List<Doctor> doctor = medicalService.getAllDoctor();
        return ResponseEntity.ok(doctor);
    }


    @GetMapping("/findDoctor/{name}")
    public ResponseEntity<Doctor> findDoctor(@PathVariable String name) {
        Optional<Doctor> o = medicalService.findDoctorByName(name);
        return o.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
