package itri.org.spring.repository.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import itri.org.spring.model.training.StatisticsGoal;

import java.util.List;

@Repository
public interface StatisticsGoalRepository extends JpaRepository<StatisticsGoal, Long> {
    List<StatisticsGoal> findByMappingId(Long mappingId);
    List<StatisticsGoal> findByApiNameContaining(String apiName);
    List<StatisticsGoal> findByValueGoalContaining(String valueGoal);
}