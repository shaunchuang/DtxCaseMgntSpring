package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByCaseNo(Long caseNo);
    List<Appointment> findByAvailableSlotId(Long availableSlotId);
    Appointment findByCaseNoAndAvailableSlotId(Long caseNo, Long availableSlotId);
}