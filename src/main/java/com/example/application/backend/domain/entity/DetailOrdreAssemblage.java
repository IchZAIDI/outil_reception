package com.example.application.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name ="ASSEMBLAGEORDREDETAIL")
public class DetailOrdreAssemblage {

    @Column(name="NoSeq_oad")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NoOrdreAss_oad")
    private String numeroAssemblage;
    @JsonBackReference
    @OneToOne(mappedBy = "detailOrdreAssemblage")
    private LignePlus lignePlus;

    public DetailOrdreAssemblage() {
    }

    public DetailOrdreAssemblage(Integer id, String numeroAssemblage, LignePlus lignePlus) {
        this.id = id;
        this.numeroAssemblage = numeroAssemblage;
        this.lignePlus = lignePlus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroAssemblage() {
        return numeroAssemblage;
    }

    public void setNumeroAssemblage(String numeroAssemblage) {
        this.numeroAssemblage = numeroAssemblage;
    }

    public LignePlus getLignePlus() {
        return lignePlus;
    }

    public void setLignePlus(LignePlus lignePlus) {
        this.lignePlus = lignePlus;
    }

    @Override
    public String toString() {
        return "DetailOrdreAssemblage{" +
                "numeroAssemblage='" + numeroAssemblage + '\'' +
                ", lignePlus=" + lignePlus +
                '}';
    }
}
