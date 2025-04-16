package itri.org.spring.service.impl;

import itri.org.spring.model.AvailableSlot;
import itri.org.spring.repository.AvailableSlotRepository;
import itri.org.spring.service.AvailableSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AvailableSlotServiceImpl implements AvailableSlotService {

    private final AvailableSlotRepository availableSlotRepository;

    @Autowired
    public AvailableSlotServiceImpl(AvailableSlotRepository availableSlotRepository) {
        this.availableSlotRepository = availableSlotRepository;
    }

    @Override
    public AvailableSlot saveAvailableSlot(AvailableSlot availableSlot) {
        return availableSlotRepository.save(availableSlot);
    }

    @Override
    public Optional<AvailableSlot> findById(Long id) {
        return availableSlotRepository.findById(id);
    }

    @Override
    public List<AvailableSlot> findByDoctorId(Long doctorId) {
        return availableSlotRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<AvailableSlot> findBySlotDate(Date slotDate) {
        return availableSlotRepository.findBySlotDate(slotDate);
    }

    @Override
    public List<AvailableSlot> findByDoctorIdAndSlotDate(Long doctorId, Date slotDate) {
        return availableSlotRepository.findByDoctorIdAndSlotDate(doctorId, slotDate);
    }

    @Override
    public List<AvailableSlot> findByIsBooked(Boolean isBooked) {
        return availableSlotRepository.findByIsBooked(isBooked);
    }

    @Override
    public List<AvailableSlot> findAllAvailableSlots() {
        return availableSlotRepository.findAll();
    }

    @Override
    public void deleteAvailableSlot(Long id) {
        availableSlotRepository.deleteById(id);
    }
}