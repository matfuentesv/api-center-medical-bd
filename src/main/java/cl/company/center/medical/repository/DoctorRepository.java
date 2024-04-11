package cl.company.center.medical.repository;

import cl.company.center.medical.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query("SELECT u FROM Doctor u WHERE u.nombre = ?1")
    Optional<Doctor> findByName(String nombre);

}
