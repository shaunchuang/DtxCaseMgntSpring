package itri.org.spring.service;

import itri.org.spring.model.Appointment;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    /**
     * 保存預約記錄
     * @param appointment 預約記錄
     * @return 保存後的預約記錄
     */
    Appointment saveAppointment(Appointment appointment);
    
    /**
     * 根據ID查找預約記錄
     * @param id 預約記錄ID
     * @return 包含預約記錄的Optional物件，若未找到則為空
     */
    Optional<Appointment> findById(Long id);
    
    /**
     * 根據個案號查找預約記錄
     * @param caseNo 個案號
     * @return 預約記錄列表
     */
    List<Appointment> findByCaseNo(Long caseNo);
    
    /**
     * 根據可用時段ID查找預約記錄
     * @param availableSlotId 可用時段ID
     * @return 預約記錄列表
     */
    List<Appointment> findByAvailableSlotId(Long availableSlotId);
    
    /**
     * 獲取所有預約記錄
     * @return 所有預約記錄的列表
     */
    List<Appointment> findAllAppointments();
    
    /**
     * 刪除預約記錄
     * @param id 預約記錄ID
     */
    void deleteAppointment(Long id);
}