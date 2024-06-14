package dio.spring_data_jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Livros")
public class Livros {

    @Override
    public String toString() {
        return "Livros [id=" + id + ", livro_name=" + livro_name + ", genero=" + genero + ", desc=" + desc + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Deprecated
    @Column(name="livro_id")
    Integer id;

    @Column(name="livro_name",nullable = false,length = 50)
    String livro_name;

    @Column(name="genero",nullable = false,length = 100)
    String genero;

    @Column(name="descricao",nullable = false,length = 250)
    String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLivro_name() {
        return livro_name;
    }

    public void setLivro_name(String livro_name) {
        this.livro_name = livro_name;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
