package com.example.application.backend.domain.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ENTREPOTS")
@Immutable
public class Entrepot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "CODE_ENTREPOT")
    private String codeEntropot;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ACTIF")
    private Boolean actif;

    @Column(name = "DISP_VENTE")
    private Boolean dispVente;

    public Entrepot() {
    }

    public Entrepot(int id, String codeEntropot, String description, Boolean actif, Boolean dispVente) {
        this.id = id;
        this.codeEntropot = codeEntropot;
        this.description = description;
        this.actif = actif;
        this.dispVente = dispVente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeEntropot() {
        return codeEntropot;
    }

    public void setCodeEntropot(String codeEntropot) {
        this.codeEntropot = codeEntropot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean getDispVente() {
        return dispVente;
    }

    public void setDispVente(Boolean dispVente) {
        this.dispVente = dispVente;
    }

    @Override
    public String toString() {
        return "EntropotView{" +
                "id=" + id +
                ", codeEntropot='" + codeEntropot + '\'' +
                ", description='" + description + '\'' +
                ", actif=" + actif +
                ", dispVente=" + dispVente +
                '}';
    }
}
