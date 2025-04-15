package itri.org.spring.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "\"patient\"")
public class Patient implements Serializable {
    private static final long serialVersionUID = 1822843074531976309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"idno\"", nullable = false, unique = true, length = 50)
    private String idno;

    @Column(name = "\"name\"", nullable = false, length = 50)
    private String name;

    @Column(name = "\"gender\"", length = 10)
    private String gender;

    @Column(name = "\"birth\"")
    @Temporal(TemporalType.DATE)
    private Date birth;

    // 不存 age，動態計算
    public int getAge() {
        if (birth == null) return 0;
        Calendar today = Calendar.getInstance();
        today.set(2025, Calendar.APRIL, 15); // 固定為 2025-04-15
        Calendar dob = Calendar.getInstance();
        dob.setTime(birth);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    @Column(name = "\"city\"", length = 50)
    private String city;

    @Column(name = "\"district\"", length = 50)
    private String district;

    @Column(name = "\"address\"", length = 255)
    private String address;

    @Column(name = "\"emergency_contact\"", length = 50)
    private String emergencyContact;

    @Column(name = "\"emergency_phone\"", length = 50)
    private String emergencyPhone;

    @Column(name = "\"emergency_relation\"", length = 50)
    private String emergencyRelation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "\"patient_history_disease\"",
        joinColumns = @JoinColumn(name = "patient_id"),
        inverseJoinColumns = @JoinColumn(name = "history_disease_id"))
    private java.util.List<HistoryDisease> historyDisease;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "\"patient_medical_history\"",
        joinColumns = @JoinColumn(name = "patient_id"),
        inverseJoinColumns = @JoinColumn(name = "medical_history_id"))
    private java.util.List<MedicalHistory> medicalHistory;

    @Column(name = "\"disease_id\"")
    private Long diseaseId;

    // getters and setters ...
}
