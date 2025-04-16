package itri.org.spring.service.impl;

import itri.org.spring.model.MedicalHistory;
import itri.org.spring.repository.MedicalHistoryRepository;
import itri.org.spring.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    @Override
    public MedicalHistory saveMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public Optional<MedicalHistory> findById(Long id) {
        return medicalHistoryRepository.findById(id);
    }

    @Override
    public List<MedicalHistory> findByName(String name) {
        return medicalHistoryRepository.findByName(name);
    }

    @Override
    public List<MedicalHistory> findByNameContaining(String keyword) {
        return medicalHistoryRepository.findByNameContaining(keyword);
    }

    @Override
    public List<MedicalHistory> findAllMedicalHistories() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public void deleteMedicalHistory(Long id) {
        medicalHistoryRepository.deleteById(id);
    }
}