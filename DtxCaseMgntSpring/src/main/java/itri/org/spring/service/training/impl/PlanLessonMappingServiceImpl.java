package itri.org.spring.service.training.impl;

import itri.org.spring.model.training.PlanLessonMapping;
import itri.org.spring.model.training.TrainingPlan;
import itri.org.spring.repository.training.PlanLessonMappingRepository;
import itri.org.spring.service.training.PlanLessonMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanLessonMappingServiceImpl implements PlanLessonMappingService {

    private final PlanLessonMappingRepository planLessonMappingRepository;

    @Autowired
    public PlanLessonMappingServiceImpl(PlanLessonMappingRepository planLessonMappingRepository) {
        this.planLessonMappingRepository = planLessonMappingRepository;
    }

    @Override
    public PlanLessonMapping savePlanLessonMapping(PlanLessonMapping planLessonMapping) {
        return planLessonMappingRepository.save(planLessonMapping);
    }

    @Override
    public Optional<PlanLessonMapping> findById(Long id) {
        return planLessonMappingRepository.findById(id);
    }

    @Override
    public List<PlanLessonMapping> findByTrainingPlan(TrainingPlan trainingPlan) {
        return planLessonMappingRepository.findByTrainingPlan(trainingPlan);
    }

    @Override
    public List<PlanLessonMapping> findByLessonId(Long lessonId) {
        return planLessonMappingRepository.findByLessonId(lessonId);
    }

    @Override
    public List<PlanLessonMapping> findByOrderIndex(Integer orderIndex) {
        return planLessonMappingRepository.findByOrderIndex(orderIndex);
    }

    @Override
    public List<PlanLessonMapping> findByStatus(String status) {
        return planLessonMappingRepository.findByStatus(status);
    }

    @Override
    public List<PlanLessonMapping> findByTrainingPlanAndOrderIndexGreaterThanEqual(TrainingPlan trainingPlan, Integer orderIndex) {
        return planLessonMappingRepository.findByTrainingPlanAndOrderIndexGreaterThanEqual(trainingPlan, orderIndex);
    }

    @Override
    public List<PlanLessonMapping> findAllPlanLessonMappings() {
        return planLessonMappingRepository.findAll();
    }

    @Override
    public void deletePlanLessonMapping(Long id) {
        planLessonMappingRepository.deleteById(id);
    }
}