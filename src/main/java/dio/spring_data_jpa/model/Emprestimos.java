package dio.spring_data_jpa.model;

import java.time.LocalDate;

import jakarta.persistence.*;;

@Entity
@Table(name="Emprestimos")
public class Emprestimos {
    @Override
    public String toString() {
        return "Emprestimos [id=" + id + ", userId=" + userId + ", data=" + data + ", nameUser=" + nameUser + "]";
    }

    public Emprestimos(Integer userId){
        this.userId = userId;
        this.data = LocalDate.now();
        
    }

    public Emprestimos() {
        //TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_id")
    private Integer id;

    @Column(name = "user_id",nullable=false)
    private Integer userId;

    @Column(name = "dataInicio",nullable=false)
    LocalDate data;

    @Column(name = "name_user",nullable = false)
    String nameUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

}
