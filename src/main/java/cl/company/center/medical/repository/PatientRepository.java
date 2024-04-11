package cl.company.center.medical.repository;

import cl.company.center.medical.repository.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Paciente,Long> {
}
