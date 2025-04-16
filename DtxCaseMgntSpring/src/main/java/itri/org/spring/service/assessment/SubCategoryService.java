package itri.org.spring.service.assessment;

import itri.org.spring.model.assessment.SubCategory;
import itri.org.spring.model.assessment.Question;
import java.util.List;
import java.util.Optional;

public interface SubCategoryService {
    /**
     * Save or update a subcategory
     * @param subCategory The subcategory to save
     * @return The saved subcategory
     */
    SubCategory saveSubCategory(SubCategory subCategory);
    
    /**
     * Find a subcategory by its ID
     * @param subCategoryId The ID of the subcategory
     * @return An Optional containing the found subcategory, or empty if not found
     */
    Optional<SubCategory> findById(String subCategoryId);
    
    /**
     * Find subcategories by question
     * @param question The question to find subcategories for
     * @return A list of subcategories for the given question
     */
    List<SubCategory> findByQuestion(Question question);
    
    /**
     * Find subcategories containing specific name
     * @param subCategoryName The name to search for
     * @return A list of subcategories with names containing the search term
     */
    List<SubCategory> findBySubCategoryNameContaining(String subCategoryName);
    
    /**
     * Get all subcategories
     * @return A list of all subcategories
     */
    List<SubCategory> findAllSubCategories();
    
    /**
     * Delete a subcategory by its ID
     * @param subCategoryId The ID of the subcategory to delete
     */
    void deleteSubCategory(String subCategoryId);
}