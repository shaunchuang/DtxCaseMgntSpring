package itri.org.spring.repository.healthinsurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import itri.org.spring.model.healthinsurance.MedicalServicePaymentItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalServicePaymentItemRepository extends JpaRepository<MedicalServicePaymentItem, Long> {
    Optional<MedicalServicePaymentItem> findByCode(String code);
    List<MedicalServicePaymentItem> findByZhItemContaining(String zhItem);
    List<MedicalServicePaymentItem> findByEnItemContaining(String enItem);
    List<MedicalServicePaymentItem> findByPointsGreaterThanEqual(int points);
    List<MedicalServicePaymentItem> findByDeleteMarkFalse();
}