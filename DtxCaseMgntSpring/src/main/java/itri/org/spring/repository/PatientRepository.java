package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.Patient;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByIdno(String idno);
    boolean existsByIdno(String idno);
    List<Patient> findByBirthBetween(Date start, Date end);
}