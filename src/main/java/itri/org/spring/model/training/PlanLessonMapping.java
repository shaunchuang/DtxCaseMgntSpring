package itri.org.spring.model.training;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "plan_lesson_mapping")
public class PlanLessonMapping implements Serializable {

    private static final long serialVersionUID = 3695124L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private TrainingPlan trainingPlan;

    @Column(name = "lesson_id", nullable = false)
    private Long lessonId;

    @Column(name = "order_index")
    private Integer orderIndex;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "create_time")
    private Date createTime;

    public PlanLessonMapping() {}
    // getters and setters ...
}
