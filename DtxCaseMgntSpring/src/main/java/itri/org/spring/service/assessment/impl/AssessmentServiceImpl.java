package itri.org.spring.service.assessment.impl;

import itri.org.spring.model.assessment.Assessment;
import itri.org.spring.repository.assessment.AssessmentRepository;
import itri.org.spring.service.assessment.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;

    @Autowired
    public AssessmentServiceImpl(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public Assessment saveAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public Optional<Assessment> findById(String assessmentId) {
        return assessmentRepository.findById(assessmentId);
    }

    @Override
    public Optional<Assessment> findByAssessmentName(String assessmentName) {
        return assessmentRepository.findByAssessmentName(assessmentName);
    }

    @Override
    public Optional<Assessment> findByAssessmentType(String assessmentType) {
        return assessmentRepository.findByAssessmentType(assessmentType);
    }

    @Override
    public List<Assessment> findAllAssessments() {
        return assessmentRepository.findAll();
    }

    @Override
    public void deleteAssessment(String assessmentId) {
        assessmentRepository.deleteById(assessmentId);
    }
}