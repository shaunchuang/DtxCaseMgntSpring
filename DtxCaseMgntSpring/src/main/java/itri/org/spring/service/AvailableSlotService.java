package itri.org.spring.service;

import itri.org.spring.model.AvailableSlot;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AvailableSlotService {
    /**
     * 保存可用時段
     * @param availableSlot 可用時段
     * @return 保存後的可用時段
     */
    AvailableSlot saveAvailableSlot(AvailableSlot availableSlot);
    
    /**
     * 根據ID查找可用時段
     * @param id 可用時段ID
     * @return 包含可用時段的Optional物件，若未找到則為空
     */
    Optional<AvailableSlot> findById(Long id);
    
    /**
     * 根據醫師ID查找可用時段
     * @param doctorId 醫師ID
     * @return 可用時段列表
     */
    List<AvailableSlot> findByDoctorId(Long doctorId);
    
    /**
     * 根據日期查找可用時段
     * @param slotDate 日期
     * @return 可用時段列表
     */
    List<AvailableSlot> findBySlotDate(Date slotDate);
    
    /**
     * 根據醫師ID和日期查找可用時段
     * @param doctorId 醫師ID
     * @param slotDate 日期
     * @return 可用時段列表
     */
    List<AvailableSlot> findByDoctorIdAndSlotDate(Long doctorId, Date slotDate);
    
    /**
     * 根據預約狀態查找可用時段
     * @param isBooked 是否已被預約
     * @return 可用時段列表
     */
    List<AvailableSlot> findByIsBooked(Boolean isBooked);
    
    /**
     * 獲取所有可用時段
     * @return 所有可用時段的列表
     */
    List<AvailableSlot> findAllAvailableSlots();
    
    /**
     * 刪除可用時段
     * @param id 可用時段ID
     */
    void deleteAvailableSlot(Long id);
}