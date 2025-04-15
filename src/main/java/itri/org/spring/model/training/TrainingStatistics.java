package itri.org.spring.model.training;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * 訓練統計
 * trainingRecord: 所屬訓練紀錄
 * statisticsGoal: 對應的統計目標
 * statValue: 統計值
 */
@Entity
@Table(name = "training_statistics")
public class TrainingStatistics implements Serializable {

    private static final long serialVersionUID = 898746512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id", nullable = false)
    private TrainingRecord trainingRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistics_goal_id", nullable = false)
    private StatisticsGoal statisticsGoal;

    @Column(name = "stat_value", nullable = false)
    private Double statValue;

    public TrainingStatistics() {}
    // getters and setters ...
}
