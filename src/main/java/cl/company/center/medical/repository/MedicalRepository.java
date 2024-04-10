package cl.company.center.medical.repository;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.MedicalRecord;
import cl.company.center.medical.model.Patient;
import java.util.List;

public interface MedicalRepository {

    List<Patient>dataSource();
}
