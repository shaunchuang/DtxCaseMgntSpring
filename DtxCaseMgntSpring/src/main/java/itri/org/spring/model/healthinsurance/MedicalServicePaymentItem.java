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

    // getters and setters ...
}
