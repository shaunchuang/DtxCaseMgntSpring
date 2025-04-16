package itri.org.spring.service.assessment;

import itri.org.spring.model.assessment.Section;
import itri.org.spring.model.assessment.Assessment;
import java.util.List;
import java.util.Optional;

public interface SectionService {
    /**
     * Save or update a section
     * @param section The section to save
     * @return The saved section
     */
    Section saveSection(Section section);
    
    /**
     * Find a section by its ID
     * @param sectionId The ID of the section
     * @return An Optional containing the found section, or empty if not found
     */
    Optional<Section> findById(String sectionId);
    
    /**
     * Find sections by containing name
     * @param sectionName The name to search for
     * @return A list of sections with names containing the search term
     */
    List<Section> findBySectionNameContaining(String sectionName);
    
    /**
     * Find sections by assessment
     * @param assessment The assessment to find sections for
     * @return A list of sections for the given assessment
     */
    List<Section> findByAssessment(Assessment assessment);
    
    /**
     * Get all sections
     * @return A list of all sections
     */
    List<Section> findAllSections();
    
    /**
     * Delete a section by its ID
     * @param sectionId The ID of the section to delete
     */
    void deleteSection(String sectionId);
}