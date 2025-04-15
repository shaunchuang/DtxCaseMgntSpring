package itri.org.spring.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"config_property\"")
public class ConfigProperty implements Serializable  {

    private static final long serialVersionUID = 3433358033025418191L;
    
    @Id
    @Column(name = "\"id\"", nullable = false, length = 255) 
    private String id; 
    
    @Column(name = "\"global_value\"", nullable = false, length = 2000) 
    private String globalValue; // 全域變數的值

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGlobalValue() {
        return globalValue;
    }

    public void setGlobalValue(String globalValue) {
        this.globalValue = globalValue;
    }

    
}
