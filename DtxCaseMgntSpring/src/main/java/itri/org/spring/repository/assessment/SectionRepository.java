package itri.org.spring.repository.assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.assessment.Section;
import itri.org.spring.model.assessment.Assessment;

import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, String> {
    Optional<Section> findBySectionId(String sectionId);
    List<Section> findByAssessment(Assessment assessment);
    List<Section> findBySectionNameContaining(String sectionName);
}