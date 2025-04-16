package itri.org.spring.model.training;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import itri.org.spring.model.Patient;

/**
 * 訓練計畫
 * therapistId: 設定計畫的治療師/醫師ID
 * patientId: 個案ID
 * title: 計畫標題
 * startDate/endDate: 計畫起訖日
 * frequencyPerWeek: 每週訓練次數
 * frequencyPerDay: 每日訓練次數
 * durationPerSession: 每次訓練分鐘數
 * notes: 備註
 * createTime: 建立時間
 * trainingRecords: 計畫下的訓練紀錄清單
 */
@Entity
@Table(name = "training_plan")
public class TrainingPlan implements Serializable {

    private static final long serialVersionUID = 8845112L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "therapist_id", nullable = false)
    private Long therapistId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "frequency_per_week")
    private Integer frequencyPerWeek;

    @Column(name = "frequency_per_day")
    private Integer frequencyPerDay;

    @Column(name = "duration_per_session")
    private Integer durationPerSession;

    @Column(name = "notes")
    private String notes;

    @Column(name = "create_time")
    private Date createTime;

    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingRecord> trainingRecords;

    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<PlanLessonMapping> planLessonMappings;

    public TrainingPlan() {}
    // getters and setters ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(Long therapistId) {
        this.therapistId = therapistId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getFrequencyPerWeek() {
        return frequencyPerWeek;
    }

    public void setFrequencyPerWeek(Integer frequencyPerWeek) {
        this.frequencyPerWeek = frequencyPerWeek;
    }

    public Integer getFrequencyPerDay() {
        return frequencyPerDay;
    }

    public void setFrequencyPerDay(Integer frequencyPerDay) {
        this.frequencyPerDay = frequencyPerDay;
    }

    public Integer getDurationPerSession() {
        return durationPerSession;
    }

    public void setDurationPerSession(Integer durationPerSession) {
        this.durationPerSession = durationPerSession;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<TrainingRecord> getTrainingRecords() {
        return trainingRecords;
    }

    public void setTrainingRecords(List<TrainingRecord> trainingRecords) {
        this.trainingRecords = trainingRecords;
    }

    public java.util.List<PlanLessonMapping> getPlanLessonMappings() {
        return planLessonMappings;
    }

    public void setPlanLessonMappings(java.util.List<PlanLessonMapping> planLessonMappings) {
        this.planLessonMappings = planLessonMappings;
    }
    
}
