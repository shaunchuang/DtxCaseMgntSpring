package itri.org.spring.service.assessment;

import itri.org.spring.model.assessment.Question;
import itri.org.spring.model.assessment.Section;
import java.util.List;
import java.util.Optional;

public interface QuestionService {
    /**
     * Save or update a question
     * @param question The question to save
     * @return The saved question
     */
    Question saveQuestion(Question question);
    
    /**
     * Find a question by its ID
     * @param questionId The ID of the question
     * @return An Optional containing the found question, or empty if not found
     */
    Optional<Question> findById(String questionId);
    
    /**
     * Find questions by section
     * @param section The section to find questions for
     * @return A list of questions for the given section
     */
    List<Question> findBySection(Section section);
    
    /**
     * Find questions by type
     * @param questionType The question type to search for
     * @return A list of questions with the given type
     */
    List<Question> findByQuestionType(String questionType);
    
    /**
     * Find questions containing specific text
     * @param questionText The text to search for in question text
     * @return A list of questions containing the search text
     */
    List<Question> findByQuestionTextContaining(String questionText);
    
    /**
     * Get all questions
     * @return A list of all questions
     */
    List<Question> findAllQuestions();
    
    /**
     * Delete a question by its ID
     * @param questionId The ID of the question to delete
     */
    void deleteQuestion(String questionId);
}