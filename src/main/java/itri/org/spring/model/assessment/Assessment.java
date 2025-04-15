package itri.org.spring.model.assessment;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "\"assessment\"")
public class Assessment implements Serializable {
    
    private static final long serialVersionUID = 4152387452L;

    @Id
    @Column(name = "\"assessment_id\"", nullable = false)
    private String assessmentId;

    @Column(name = "\"assessment_name\"", nullable = false)
    private String assessmentName;

    @Column(name = "\"assessment_type\"", nullable = true)
    private String assessmentType;

    @Column(name = "\"assessment_description\"", nullable = true)
    private String assessmentDescription;

    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Section> sections;

    // getters and setters
    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getAssessmentDescription() {
        return assessmentDescription;
    }

    public void setAssessmentDescription(String assessmentDescription) {
        this.assessmentDescription = assessmentDescription;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
