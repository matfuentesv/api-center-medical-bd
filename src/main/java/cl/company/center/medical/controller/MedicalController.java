package cl.company.center.medical.controller;

import cl.company.center.medical.model.Doctor;

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

    @GetMapping("/getAllDoctors")
    public ResponseEntity<List<Doctor>> getAllPatients() {
        return ResponseEntity.ok(medicalService.getAllDoctor());
    }

//    @GetMapping("/historicalMedicalRecords/{patientName}")
//    public ResponseEntity<List<MedicalRecord>> getMedicalRecord(@PathVariable String patientName) {
//        return ResponseEntity.ok(medicalService.getMedicalRecord(patientName));
//    }
//
//    @GetMapping("/allMedicalRecords")
//    public ResponseEntity<List<Doctor>> getAllMedicalRecords() {
//        List<Doctor> doctor = medicalService.getAllDoctor();
//        return ResponseEntity.ok(doctor);
//    }
//
//    @GetMapping("/findDoctor/{name}")
//    public ResponseEntity<Doctor> findDoctor(@PathVariable String name) {
//        Doctor doctor = medicalService.findDoctorByName(name);
//        return ResponseEntity.ok(doctor);
//    }


}
