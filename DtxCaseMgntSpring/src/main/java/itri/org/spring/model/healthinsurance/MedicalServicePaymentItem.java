package itri.org.spring.model.healthinsurance;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "\"medical_service_payment_item\"")
public class MedicalServicePaymentItem implements Serializable {
    
    private static final long serialVersionUID = 18451238465132L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"code\"", length = 20)
    private String code;

    @Column(name = "\"points\"")
    private int points;

    @Column(name = "\"begin_date\"", length = 20)
    private String beginDate;

    @Column(name = "\"end_date\"", length = 20)
    private String endDate;

    @Column(name = "\"zh_item\"")
    private String zhItem;

    @Column(name = "\"en_item\"")
    private String enItem;

    @Column(name = "\"note\"")
    private String note;

    @Column(name = "\"create_time\"")
    private Date createTime;

    @Column(name = "\"modify_time\"")
    private Date modifyTime;

    @Column(name = "\"creator_id\"")
    private Long creator;

    @Column(name = "\"modifier_id\"")
    private Long modifier;

    @Column(name = "\"deletemark\"")
    private Boolean deleteMark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getZhItem() {
        return zhItem;
    }

    public void setZhItem(String zhItem) {
        this.zhItem = zhItem;
    }

    public String getEnItem() {
        return enItem;
    }

    public void setEnItem(String enItem) {
        this.enItem = enItem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Boolean getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Boolean deleteMark) {
        this.deleteMark = deleteMark;
    }

    // getters and setters ...
    
}
