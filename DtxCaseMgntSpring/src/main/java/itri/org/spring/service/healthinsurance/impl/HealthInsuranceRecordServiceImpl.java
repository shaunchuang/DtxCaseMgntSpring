package itri.org.spring.service.healthinsurance.impl;

import itri.org.spring.model.Patient;
import itri.org.spring.model.healthinsurance.HealthInsuranceRecord;
import itri.org.spring.repository.healthinsurance.HealthInsuranceRecordRepository;
import itri.org.spring.service.healthinsurance.HealthInsuranceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HealthInsuranceRecordServiceImpl implements HealthInsuranceRecordService {

    private final HealthInsuranceRecordRepository healthInsuranceRecordRepository;

    @Autowired
    public HealthInsuranceRecordServiceImpl(HealthInsuranceRecordRepository healthInsuranceRecordRepository) {
        this.healthInsuranceRecordRepository = healthInsuranceRecordRepository;
    }

    @Override
    public HealthInsuranceRecord saveHealthInsuranceRecord(HealthInsuranceRecord healthInsuranceRecord) {
        return healthInsuranceRecordRepository.save(healthInsuranceRecord);
    }

    @Override
    public Optional<HealthInsuranceRecord> findById(Long id) {
        return healthInsuranceRecordRepository.findById(id);
    }

    @Override
    public List<HealthInsuranceRecord> findByPatient(Patient patient) {
        return healthInsuranceRecordRepository.findByPatient(patient);
    }

    @Override
    public HealthInsuranceRecord findBySerialNum(String serialNum) {
        return healthInsuranceRecordRepository.findBySerialNum(serialNum);
    }

    @Override
    public List<HealthInsuranceRecord> findAllHealthInsuranceRecords() {
        return healthInsuranceRecordRepository.findAll();
    }

    @Override
    public void deleteHealthInsuranceRecord(Long id) {
        healthInsuranceRecordRepository.deleteById(id);
    }
}