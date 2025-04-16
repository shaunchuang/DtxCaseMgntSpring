package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    MedicalHistory findByName(String name);
}