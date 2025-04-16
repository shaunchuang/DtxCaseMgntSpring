package itri.org.spring.service.training.impl;

import itri.org.spring.model.training.StatisticsGoal;
import itri.org.spring.repository.training.StatisticsGoalRepository;
import itri.org.spring.service.training.StatisticsGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatisticsGoalServiceImpl implements StatisticsGoalService {

    private final StatisticsGoalRepository statisticsGoalRepository;

    @Autowired
    public StatisticsGoalServiceImpl(StatisticsGoalRepository statisticsGoalRepository) {
        this.statisticsGoalRepository = statisticsGoalRepository;
    }

    @Override
    public StatisticsGoal saveStatisticsGoal(StatisticsGoal statisticsGoal) {
        return statisticsGoalRepository.save(statisticsGoal);
    }

    @Override
    public Optional<StatisticsGoal> findById(Long id) {
        return statisticsGoalRepository.findById(id);
    }

    @Override
    public List<StatisticsGoal> findByMappingId(Long mappingId) {
        return statisticsGoalRepository.findByMappingId(mappingId);
    }

    @Override
    public List<StatisticsGoal> findByApiNameContaining(String apiName) {
        return statisticsGoalRepository.findByApiNameContaining(apiName);
    }

    @Override
    public List<StatisticsGoal> findByValueGoalContaining(String valueGoal) {
        return statisticsGoalRepository.findByValueGoalContaining(valueGoal);
    }

    @Override
    public List<StatisticsGoal> findAllStatisticsGoals() {
        return statisticsGoalRepository.findAll();
    }

    @Override
    public void deleteStatisticsGoal(Long id) {
        statisticsGoalRepository.deleteById(id);
    }
}