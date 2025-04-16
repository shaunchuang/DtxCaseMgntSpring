package itri.org.spring.service.assessment;

import itri.org.spring.model.assessment.Assessment;
import java.util.List;
import java.util.Optional;

public interface AssessmentService {
    /**
     * Save or update an assessment
     * @param assessment The assessment to save
     * @return The saved assessment
     */
    Assessment saveAssessment(Assessment assessment);
    
    /**
     * Find an assessment by its ID
     * @param assessmentId The ID of the assessment
     * @return An Optional containing the found assessment, or empty if not found
     */
    Optional<Assessment> findById(String assessmentId);
    
    /**
     * Find an assessment by its name
     * @param assessmentName The name of the assessment
     * @return An Optional containing the found assessment, or empty if not found
     */
    Optional<Assessment> findByAssessmentName(String assessmentName);
    
    /**
     * Find assessments by type
     * @param assessmentType The type of the assessment
     * @return An Optional containing the found assessment, or empty if not found
     */
    Optional<Assessment> findByAssessmentType(String assessmentType);
    
    /**
     * Get all assessments
     * @return A list of all assessments
     */
    List<Assessment> findAllAssessments();
    
    /**
     * Delete an assessment by its ID
     * @param assessmentId The ID of the assessment to delete
     */
    void deleteAssessment(String assessmentId);
}