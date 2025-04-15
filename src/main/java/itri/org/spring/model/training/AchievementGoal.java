package itri.org.spring.model.training;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * 成就目標
 * mappingId: 訓練計畫與課程的對應ID
 * apiName: API名稱
 */
@Entity
@Table(name = "achievement_goal")
public class AchievementGoal implements Serializable {

    private static final long serialVersionUID = 87895412L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mapping_id")
    private Long mappingId; // 訓練計畫與課程的對應ID

    @Column(name = "api_name")
    private String apiName; // API名稱

    public AchievementGoal() {}
    // getters and setters ...
}
