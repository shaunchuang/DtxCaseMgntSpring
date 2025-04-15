package itri.org.spring.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medical_history")
public class MedicalHistory implements Serializable {

    private static final long serialVersionUID = 878453512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name; // 病史名稱

    @Column(name = "description", length = 255)
    private String description; // 補充說明

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}