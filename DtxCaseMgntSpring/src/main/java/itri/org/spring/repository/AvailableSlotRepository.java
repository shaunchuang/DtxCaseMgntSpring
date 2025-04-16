package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.AvailableSlot;

import java.util.Date;
import java.util.List;

public interface AvailableSlotRepository extends JpaRepository<AvailableSlot, Long> {
    List<AvailableSlot> findByDoctorId(Long doctorId);
    List<AvailableSlot> findBySlotDate(Date slotDate);
    List<AvailableSlot> findByDoctorIdAndSlotDate(Long doctorId, Date slotDate);
    List<AvailableSlot> findByDoctorIdAndSlotDateAndIsBooked(Long doctorId, Date slotDate, Boolean isBooked);
}