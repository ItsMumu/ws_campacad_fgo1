package fr.campusacad.ws.dao.RO;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="book")
public class BooksRO implements Serializable {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nom")
    private String nom;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name="autor_id" )
    private AutorRO auteur;

    @Column(name="date")
    private String date;

    //default constructor
    public BooksRO(){ }

    public BooksRO(String nom, AutorRO auteur, String date,int id){

        this.nom = nom;
        this.auteur = auteur;
        this.date = date;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public AutorRO getAuteur() {
        return auteur;
    }

    public void setAuteur(AutorRO auteur) {
        this.auteur = auteur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
