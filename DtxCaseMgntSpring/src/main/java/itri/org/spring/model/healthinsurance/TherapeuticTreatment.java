package itri.org.spring.model.healthinsurance;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "therapeutic_treatment")
public class TherapeuticTreatment implements Serializable {

    private static final long serialVersionUID = 894896545L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hi_record_id", nullable = false)
    private HealthInsuranceRecord hiRecord;

    @Column(name = "treatment_code", length = 50)
    private String treatmentCode;

    @Column(name = "total_mount", length = 50)
    private String totalMount;

    @Column(name = "point")
    private int point;

    @Column(name = "executive_id", nullable = false)
    private Long executiveId;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;

    // getters and setters ...
}
