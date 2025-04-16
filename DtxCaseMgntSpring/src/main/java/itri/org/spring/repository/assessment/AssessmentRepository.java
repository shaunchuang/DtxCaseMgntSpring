package itri.org.spring.repository.assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.assessment.Assessment;

import java.util.Optional;

public interface AssessmentRepository extends JpaRepository<Assessment, String> {
    Optional<Assessment> findByAssessmentId(String assessmentId);
    Optional<Assessment> findByAssessmentName(String assessmentName);
    Optional<Assessment> findByAssessmentType(String assessmentType);
}