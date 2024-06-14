package dio.spring_data_jpa.model;

import jakarta.persistence.*;

@Entity
@Table(name="Usuarios")
public class User {
    
    public User() {
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;
    
    @Column(length = 100,nullable = false)
    private String password;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name  + ", password=" + password + "]";
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
   
}
