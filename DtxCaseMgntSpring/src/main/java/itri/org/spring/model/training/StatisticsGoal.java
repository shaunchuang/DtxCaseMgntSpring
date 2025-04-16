package itri.org.spring.model.training;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * 統計目標
 * mappingId: 訓練計畫與課程的對應ID
 * apiName: API名稱
 * valueGoal: 目標值
 */
@Entity
@Table(name = "statistics_goal")
public class StatisticsGoal implements Serializable {

    private static final long serialVersionUID = 7895412L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mapping_id")
    private Long mappingId; // 訓練計畫與課程的對應ID

    @Column(name = "api_name", nullable = false, length = 1000)
    private String apiName; // API名稱

    @Column(name = "value_goal", nullable = false)
    private String valueGoal;

    public StatisticsGoal() {}
    // getters and setters ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMappingId() {
        return mappingId;
    }

    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getValueGoal() {
        return valueGoal;
    }

    public void setValueGoal(String valueGoal) {
        this.valueGoal = valueGoal;
    }
    
}
