package itri.org.spring.service.assessment.impl;

import itri.org.spring.model.assessment.Question;
import itri.org.spring.model.assessment.Section;
import itri.org.spring.repository.assessment.QuestionRepository;
import itri.org.spring.service.assessment.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Optional<Question> findById(String questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public List<Question> findBySection(Section section) {
        return questionRepository.findBySection(section);
    }

    @Override
    public List<Question> findByQuestionType(String questionType) {
        return questionRepository.findByQuestionType(questionType);
    }

    @Override
    public List<Question> findByQuestionTextContaining(String questionText) {
        return questionRepository.findByQuestionTextContaining(questionText);
    }

    @Override
    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public void deleteQuestion(String questionId) {
        questionRepository.deleteById(questionId);
    }
}