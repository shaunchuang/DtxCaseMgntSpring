package itri.org.spring.service.healthinsurance.impl;

import itri.org.spring.model.healthinsurance.MedicalServicePaymentItem;
import itri.org.spring.repository.healthinsurance.MedicalServicePaymentItemRepository;
import itri.org.spring.service.healthinsurance.MedicalServicePaymentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicalServicePaymentItemServiceImpl implements MedicalServicePaymentItemService {

    private final MedicalServicePaymentItemRepository medicalServicePaymentItemRepository;

    @Autowired
    public MedicalServicePaymentItemServiceImpl(MedicalServicePaymentItemRepository medicalServicePaymentItemRepository) {
        this.medicalServicePaymentItemRepository = medicalServicePaymentItemRepository;
    }

    @Override
    public MedicalServicePaymentItem saveMedicalServicePaymentItem(MedicalServicePaymentItem medicalServicePaymentItem) {
        return medicalServicePaymentItemRepository.save(medicalServicePaymentItem);
    }

    @Override
    public Optional<MedicalServicePaymentItem> findById(Long id) {
        return medicalServicePaymentItemRepository.findById(id);
    }

    @Override
    public Optional<MedicalServicePaymentItem> findByCode(String code) {
        return medicalServicePaymentItemRepository.findByCode(code);
    }

    @Override
    public List<MedicalServicePaymentItem> findByZhItemContaining(String zhItem) {
        return medicalServicePaymentItemRepository.findByZhItemContaining(zhItem);
    }

    @Override
    public List<MedicalServicePaymentItem> findByEnItemContaining(String enItem) {
        return medicalServicePaymentItemRepository.findByEnItemContaining(enItem);
    }

    @Override
    public List<MedicalServicePaymentItem> findByPointsGreaterThanEqual(int points) {
        return medicalServicePaymentItemRepository.findByPointsGreaterThanEqual(points);
    }

    @Override
    public List<MedicalServicePaymentItem> findByDeleteMarkFalse() {
        return medicalServicePaymentItemRepository.findByDeleteMarkFalse();
    }

    @Override
    public List<MedicalServicePaymentItem> findAllMedicalServicePaymentItems() {
        return medicalServicePaymentItemRepository.findAll();
    }

    @Override
    public void deleteMedicalServicePaymentItem(Long id) {
        medicalServicePaymentItemRepository.deleteById(id);
    }

    @Override
    public MedicalServicePaymentItem markAsDeleted(Long id) {
        Optional<MedicalServicePaymentItem> optionalItem = medicalServicePaymentItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            MedicalServicePaymentItem item = optionalItem.get();
            item.setDeleteMark(true);
            item.setModifyTime(new Date());
            return medicalServicePaymentItemRepository.save(item);
        }
        return null;
    }
}