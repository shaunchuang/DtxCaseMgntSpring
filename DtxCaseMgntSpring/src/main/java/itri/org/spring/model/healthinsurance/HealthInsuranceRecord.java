package itri.org.spring.model.healthinsurance;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import itri.org.spring.model.Patient;

@Entity
@Table(name = "\"health_insurance_record\"")
public class HealthInsuranceRecord implements Serializable {

    private static final long serialVersionUID = 812658479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"patient_id\"", nullable = false)
    private Patient patient;

    @Lob
    @Column(name = "\"subjective\"")
    private String subjective;

    @Lob
    @Column(name = "\"objective\"")
    private String objective;

    @Column(name = "\"main_diagnosis_code\"", length = 50)
    private String mainDiagnosisCode;

    @ElementCollection
    @CollectionTable(name = "\"health_insurance_secondary_diagnosis\"", joinColumns = @JoinColumn(name = "\"record_id\""))
    @Column(name = "\"diagnosis_code\"", length = 50, nullable = false)
    private List<String> secondaryDiagnosisCodes = new ArrayList<>();

    @Column(name = "\"copayment_code\"", length = 50)
    private String copaymentCode;

    @Column(name = "\"total_point\"")
    private int totalPoint;

    @Column(name = "\"copayment\"")
    private int copayment;

    @Column(name = "\"serial_num\"", length = 50)
    private String serialNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getSubjective() {
        return subjective;
    }

    public void setSubjective(String subjective) {
        this.subjective = subjective;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getMainDiagnosisCode() {
        return mainDiagnosisCode;
    }

    public void setMainDiagnosisCode(String mainDiagnosisCode) {
        this.mainDiagnosisCode = mainDiagnosisCode;
    }

    public List<String> getSecondaryDiagnosisCodes() {
        return secondaryDiagnosisCodes;
    }

    public void setSecondaryDiagnosisCodes(List<String> secondaryDiagnosisCodes) {
        this.secondaryDiagnosisCodes = secondaryDiagnosisCodes;
    }

    public String getCopaymentCode() {
        return copaymentCode;
    }

    public void setCopaymentCode(String copaymentCode) {
        this.copaymentCode = copaymentCode;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getCopayment() {
        return copayment;
    }

    public void setCopayment(int copayment) {
        this.copayment = copayment;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    // getters and setters ...
    
}
