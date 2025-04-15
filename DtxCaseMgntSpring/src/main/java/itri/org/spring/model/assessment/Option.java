package itri.org.spring.model.assessment;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"option_item\"")
public class Option implements Serializable {
    
    private static final long serialVersionUID = 17846578465L;

    @Id
    @Column(name = "\"option_id\"", nullable = false)
    private String optionId;

    @Column(name = "\"option_text\"", nullable = false)
    private String optionText;

    @Column(name = "\"option_type\"", nullable = false)
    private String optionType;

    @Column(name = "\"option_score\"", nullable = false)
    private Integer optionScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"subcategory_id\"", nullable = false)
    private SubCategory subCategory;

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public Integer getOptionScore() {
        return optionScore;
    }

    public void setOptionScore(Integer optionScore) {
        this.optionScore = optionScore;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

}
