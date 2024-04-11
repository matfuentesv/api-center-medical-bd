package cl.company.center.medical.repository;

import cl.company.center.medical.model.HistoricalMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<HistoricalMedical,Long> {
}
