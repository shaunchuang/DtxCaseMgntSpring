package itri.org.spring.service.assessment;

import itri.org.spring.model.assessment.Option;
import itri.org.spring.model.assessment.SubCategory;
import java.util.List;
import java.util.Optional;

public interface OptionService {
    /**
     * Save or update an option
     * @param option The option to save
     * @return The saved option
     */
    Option saveOption(Option option);
    
    /**
     * Find an option by its ID
     * @param optionId The ID of the option
     * @return An Optional containing the found option, or empty if not found
     */
    Optional<Option> findById(String optionId);
    
    /**
     * Find options by subcategory
     * @param subCategory The subcategory to find options for
     * @return A list of options for the given subcategory
     */
    List<Option> findBySubCategory(SubCategory subCategory);
    
    /**
     * Find options by type
     * @param optionType The option type to search for
     * @return A list of options with the given type
     */
    List<Option> findByOptionType(String optionType);
    
    /**
     * Find options by score
     * @param optionScore The score to search for
     * @return A list of options with the given score
     */
    List<Option> findByOptionScore(Integer optionScore);
    
    /**
     * Find options containing specific text
     * @param optionText The text to search for in option text
     * @return A list of options containing the search text
     */
    List<Option> findByOptionTextContaining(String optionText);
    
    /**
     * Get all options
     * @return A list of all options
     */
    List<Option> findAllOptions();
    
    /**
     * Delete an option by its ID
     * @param optionId The ID of the option to delete
     */
    void deleteOption(String optionId);
}