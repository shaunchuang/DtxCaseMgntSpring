package itri.org.spring.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "\"icd_code\"")
public class IcdCode implements Serializable {

    private static final long serialVersionUID = 74523658L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"code\"", nullable = false, length = 20)
    private String code; // 診斷碼

    @Column(name = "\"pure_code\"", length = 20)
    private String pureCode; // 診斷碼(去除.)

    @Column(name = "\"name\"", length = 100)
    private String name; // 診斷中文名稱

    @Column(name = "\"en_name\"", length = 100)
    private String enName; // 診斷英文名稱

    @Column(name = "\"create_time\"")
    private Date createTime; // 建立時間

    @Column(name = "\"modify_time\"")
    private Date modifyTime; // 更新時間

    @Column(name = "\"creator_id\"")
    private Long creator; // 建立者

    @Column(name = "\"modifier_id\"")
    private Long modifier; // 更新者

    @Column(name = "\"delete_mark\"")
    private Boolean deleteMark = false; // 刪除註記

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

    public String getPureCode() {
        return pureCode;
    }

    public void setPureCode(String pureCode) {
        this.pureCode = pureCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
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
