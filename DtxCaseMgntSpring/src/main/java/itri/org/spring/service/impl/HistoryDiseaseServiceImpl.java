package itri.org.spring.service.impl;

import itri.org.spring.model.HistoryDisease;
import itri.org.spring.repository.HistoryDiseaseRepository;
import itri.org.spring.service.HistoryDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class HistoryDiseaseServiceImpl implements HistoryDiseaseService {

    private final HistoryDiseaseRepository historyDiseaseRepository;

    @Autowired
    public HistoryDiseaseServiceImpl(HistoryDiseaseRepository historyDiseaseRepository) {
        this.historyDiseaseRepository = historyDiseaseRepository;
    }

    @Override
    public HistoryDisease saveHistoryDisease(HistoryDisease historyDisease) {
        return historyDiseaseRepository.save(historyDisease);
    }

    @Override
    public Optional<HistoryDisease> findById(Long id) {
        return historyDiseaseRepository.findById(id);
    }

    @Override
    public List<HistoryDisease> findByName(String name) {
        HistoryDisease historyDisease = historyDiseaseRepository.findByName(name);
        List<HistoryDisease> result = new ArrayList<>();
        if (historyDisease != null) {
            result.add(historyDisease);
        }
        return result;
    }

    @Override
    public List<HistoryDisease> findByNameContaining(String keyword) {
        // 由於沒有現成的repository方法，使用findAll加上過濾
        return historyDiseaseRepository.findAll().stream()
                .filter(disease -> disease.getName() != null && disease.getName().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoryDisease> findAllHistoryDiseases() {
        return historyDiseaseRepository.findAll();
    }

    @Override
    public void deleteHistoryDisease(Long id) {
        historyDiseaseRepository.deleteById(id);
    }
}