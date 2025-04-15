package itri.org.spring.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "\"available_slot\"")
public class AvailableSlot implements Serializable {

    private static final long serialVersionUID = 321654528L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"doctor_id\"", nullable = false)
    private Long doctorId; // 醫師或治療師的ID

    @Column(name = "\"slot_date\"", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date slotDate; // 可預約日期

    @Column(name = "\"slot_begin_time\"", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date slotBeginTime; // 時段開始時間

    @Column(name = "\"slot_end_time\"", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date slotEndTime; // 時段結束時間

    @Column(name = "\"is_booked\"", nullable = false)
    private Boolean isBooked = false; // 該時段是否已被預約

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

    public Date getSlotBeginTime() {
        return slotBeginTime;
    }

    public void setSlotBeginTime(Date slotBeginTime) {
        this.slotBeginTime = slotBeginTime;
    }

    public Date getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(Date slotEndTime) {
        this.slotEndTime = slotEndTime;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Boolean isBooked) {
        this.isBooked = isBooked;
    }

    // getters and setters ...
}
