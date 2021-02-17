package fr.campusacad.ws.dao.RO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="autor")
public class AutorRO implements Serializable {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="autor_id")
    private int autor_id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="age")
    private String age;

    @JsonIgnore
    @OneToMany(mappedBy="auteur")
    private List<BooksRO> books;

    public AutorRO(){}

    public AutorRO(String nom, String prenom, String age, List<BooksRO> books ){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.books = books;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<BooksRO> getBooks() {
        return books;
    }

    public void setBooks(List<BooksRO> books) {
        this.books = books;
    }
}
