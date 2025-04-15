package itri.org.spring.model.training;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * 訓練成就
 * trainingRecord: 所屬訓練紀錄
 * achievementGoal: 對應的成就目標
 * isUnlocked: 是否已解鎖
 * unlockTime: 解鎖時間
 */
@Entity
@Table(name = "training_achievement")
public class TrainingAchievement implements Serializable {

    private static final long serialVersionUID = 845199632L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id", nullable = false)
    private TrainingRecord trainingRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "achievement_goal_id", nullable = false)
    private AchievementGoal achievementGoal;

    @Column(name = "is_unlocked", nullable = false)
    private boolean isUnlocked = false;

    @Column(name = "unlock_time")
    private java.util.Date unlockTime;

    public TrainingAchievement() {}
    // getters and setters ...
}
