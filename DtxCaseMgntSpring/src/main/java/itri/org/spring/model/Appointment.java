package itri.org.spring.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 8946512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "case_no", nullable = false)
    private Long caseNo; // 個案表單號

    @Column(name = "available_slot_id", nullable = false)
    private Long availableSlotId; // 關聯可預約時段

    @Column(name = "checkin_time")
    @Temporal(TemporalType.TIME)
    private Date checkinTime; // 實際報到時間

    @Column(name = "note")
    private String note; // 相關備註

    @Column(name = "collaborate_id")
    private String collaborateId; // 協同人員

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(Long caseNo) {
        this.caseNo = caseNo;
    }

    public Long getAvailableSlotId() {
        return availableSlotId;
    }

    public void setAvailableSlotId(Long availableSlotId) {
        this.availableSlotId = availableSlotId;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCollaborateId() {
        return collaborateId;
    }

    public void setCollaborateId(String collaborateId) {
        this.collaborateId = collaborateId;
    }

    // getters and setters ...
}
