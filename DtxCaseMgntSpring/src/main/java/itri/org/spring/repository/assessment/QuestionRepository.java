package itri.org.spring.repository.assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.assessment.Question;
import itri.org.spring.model.assessment.Section;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, String> {
    Optional<Question> findByQuestionId(String questionId);
    List<Question> findBySection(Section section);
    List<Question> findByQuestionType(String questionType);
    List<Question> findByQuestionTextContaining(String questionText);
}