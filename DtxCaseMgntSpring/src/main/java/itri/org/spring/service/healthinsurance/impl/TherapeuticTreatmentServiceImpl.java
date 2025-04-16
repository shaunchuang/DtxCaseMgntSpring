package itri.org.spring.service.healthinsurance.impl;

import itri.org.spring.model.healthinsurance.TherapeuticTreatment;
import itri.org.spring.model.healthinsurance.HealthInsuranceRecord;
import itri.org.spring.repository.healthinsurance.TherapeuticTreatmentRepository;
import itri.org.spring.service.healthinsurance.TherapeuticTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TherapeuticTreatmentServiceImpl implements TherapeuticTreatmentService {

    private final TherapeuticTreatmentRepository therapeuticTreatmentRepository;

    @Autowired
    public TherapeuticTreatmentServiceImpl(TherapeuticTreatmentRepository therapeuticTreatmentRepository) {
        this.therapeuticTreatmentRepository = therapeuticTreatmentRepository;
    }

    @Override
    public TherapeuticTreatment saveTherapeuticTreatment(TherapeuticTreatment therapeuticTreatment) {
        return therapeuticTreatmentRepository.save(therapeuticTreatment);
    }

    @Override
    public Optional<TherapeuticTreatment> findById(Long id) {
        return therapeuticTreatmentRepository.findById(id);
    }

    @Override
    public List<TherapeuticTreatment> findByHiRecord(HealthInsuranceRecord hiRecord) {
        return therapeuticTreatmentRepository.findByHiRecord(hiRecord);
    }

    @Override
    public List<TherapeuticTreatment> findByTreatmentCode(String treatmentCode) {
        return therapeuticTreatmentRepository.findByTreatmentCode(treatmentCode);
    }

    @Override
    public List<TherapeuticTreatment> findByExecutiveId(Long executiveId) {
        return therapeuticTreatmentRepository.findByExecutiveId(executiveId);
    }

    @Override
    public List<TherapeuticTreatment> findByPoint(int point) {
        return therapeuticTreatmentRepository.findByPoint(point);
    }

    @Override
    public List<TherapeuticTreatment> findByStartTimeBetween(Date startTime, Date endTime) {
        return therapeuticTreatmentRepository.findByStartTimeBetween(startTime, endTime);
    }

    @Override
    public List<TherapeuticTreatment> findAllTherapeuticTreatments() {
        return therapeuticTreatmentRepository.findAll();
    }

    @Override
    public void deleteTherapeuticTreatment(Long id) {
        therapeuticTreatmentRepository.deleteById(id);
    }
}