package itri.org.spring.model.healthinsurance;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import itri.org.spring.model.Patient;

@Entity
@Table(name = "health_insurance_record")
public class HealthInsuranceRecord implements Serializable {

    private static final long serialVersionUID = 812658479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Lob
    @Column(name = "subjective")
    private String subjective;

    @Lob
    @Column(name = "objective")
    private String objective;

    @Column(name = "main_diagnosis_code", length = 50)
    private String mainDiagnosisCode;

    @ElementCollection
    @CollectionTable(name = "health_insurance_secondary_diagnosis", joinColumns = @JoinColumn(name = "record_id"))
    @Column(name = "diagnosis_code", length = 50, nullable = false)
    private List<String> secondaryDiagnosisCodes = new ArrayList<>();

    @Column(name = "copayment_code", length = 50)
    private String copaymentCode;

    @Column(name = "total_point")
    private int totalPoint;

    @Column(name = "copayment")
    private int copayment;

    @Column(name = "serial_num", length = 50)
    private String serialNum;

    // getters and setters ...
}
