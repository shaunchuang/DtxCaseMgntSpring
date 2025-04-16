package itri.org.spring.repository.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import itri.org.spring.model.training.AchievementGoal;

import java.util.List;

@Repository
public interface AchievementGoalRepository extends JpaRepository<AchievementGoal, Long> {
    List<AchievementGoal> findByMappingId(Long mappingId);
    List<AchievementGoal> findByApiNameContaining(String apiName);
}