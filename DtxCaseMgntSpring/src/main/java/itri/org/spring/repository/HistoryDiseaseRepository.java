package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.HistoryDisease;

public interface HistoryDiseaseRepository extends JpaRepository<HistoryDisease, Long> {
    HistoryDisease findByName(String name);
}