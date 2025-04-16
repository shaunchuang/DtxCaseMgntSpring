package itri.org.spring.service.training.impl;

import itri.org.spring.model.training.AchievementGoal;
import itri.org.spring.repository.training.AchievementGoalRepository;
import itri.org.spring.service.training.AchievementGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AchievementGoalServiceImpl implements AchievementGoalService {

    private final AchievementGoalRepository achievementGoalRepository;

    @Autowired
    public AchievementGoalServiceImpl(AchievementGoalRepository achievementGoalRepository) {
        this.achievementGoalRepository = achievementGoalRepository;
    }

    @Override
    public AchievementGoal saveAchievementGoal(AchievementGoal achievementGoal) {
        return achievementGoalRepository.save(achievementGoal);
    }

    @Override
    public Optional<AchievementGoal> findById(Long id) {
        return achievementGoalRepository.findById(id);
    }

    @Override
    public List<AchievementGoal> findByMappingId(Long mappingId) {
        return achievementGoalRepository.findByMappingId(mappingId);
    }

    @Override
    public List<AchievementGoal> findByApiNameContaining(String apiName) {
        return achievementGoalRepository.findByApiNameContaining(apiName);
    }

    @Override
    public List<AchievementGoal> findAllAchievementGoals() {
        return achievementGoalRepository.findAll();
    }

    @Override
    public void deleteAchievementGoal(Long id) {
        achievementGoalRepository.deleteById(id);
    }
}