package cl.company.center.medical.repository;

import cl.company.center.medical.repository.model.Historial_Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<Historial_Medico,Long> {
}
