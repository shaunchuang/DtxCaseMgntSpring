package itri.org.spring.model.training;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import itri.org.spring.model.Patient;

/**
 * 訓練紀錄
 * trainingPlan: 所屬訓練計畫
 * patientId: 個案ID
 * trainingDate: 訓練日期
 * durationMinutes: 訓練時長(分鐘)
 * trainingData: 訓練原始資料(JSON等)
 * successRate: 成功率
 * createdAt/updatedAt: 建立/更新時間
 * statistics: 訓練統計清單
 * achievements: 訓練成就清單
 */
@Entity
@Table(name = "training_record")
public class TrainingRecord implements Serializable {

    private static final long serialVersionUID = 89448512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private TrainingPlan trainingPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_lesson_mapping_id", nullable = false)
    private PlanLessonMapping planLessonMapping;

    @Column(name = "training_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trainingStartTime;

    @Column(name = "training_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trainingEndTime;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "success_rate")
    private Double successRate;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "trainingRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingStatistics> statistics;

    @OneToMany(mappedBy = "trainingRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingAchievement> achievements;

    public TrainingRecord() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PlanLessonMapping getPlanLessonMapping() {
        return planLessonMapping;
    }

    public void setPlanLessonMapping(PlanLessonMapping planLessonMapping) {
        this.planLessonMapping = planLessonMapping;
    }

    public Date getTrainingStartTime() {
        return trainingStartTime;
    }

    public void setTrainingStartTime(Date trainingStartTime) {
        this.trainingStartTime = trainingStartTime;
    }

    public Date getTrainingEndTime() {
        return trainingEndTime;
    }

    public void setTrainingEndTime(Date trainingEndTime) {
        this.trainingEndTime = trainingEndTime;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<TrainingStatistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<TrainingStatistics> statistics) {
        this.statistics = statistics;
    }

    public List<TrainingAchievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<TrainingAchievement> achievements) {
        this.achievements = achievements;
    }
    
    
}
