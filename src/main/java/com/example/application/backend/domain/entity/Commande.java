package com.example.application.backend.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@IdClass(CommandeId.class)
@Table(name ="FACTURATION_ACOMBA_ENTETES")
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="InInvoiceType")
    @Id
    private int invoiceType;

    @Column(name="InInvoiceNumber")
    @Id
    private String invoiceNumber;

    @Column(name="InReceivableOffset")
    @Id
    private int receivableOffset;

    @Column(name="InName")
    private String inName;

    @Column(name="InDate")
    private Date inDate;

    @Column(name="InShipName")
    private String inShipName;

    @Column(name="InInvoiceTotal")
    private float inTotal;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="InInvoiceType",referencedColumnName="InInvoiceType",insertable=false, updatable=false),
            @JoinColumn(name="InInvoiceNumber",referencedColumnName="InInvoiceNumber",insertable=false, updatable=false),
            @JoinColumn(name="InReceivableOffset",referencedColumnName="InReceivableOffset",insertable=false, updatable=false)
    })
    private List<LigneCommande> lignesCommande = new ArrayList<>();

    public Commande() {
    }

    public Commande(String inName, Date inDate, String inShipName, float inTotal, List<LigneCommande> lignesCommande) {
        this.inName = inName;
        this.inDate = inDate;
        this.inShipName = inShipName;
        this.inTotal = inTotal;
        this.lignesCommande = lignesCommande;
    }

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getReceivableOffset() {
        return receivableOffset;
    }

    public void setReceivableOffset(int receivableOffset) {
        this.receivableOffset = receivableOffset;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getInShipName() {
        return inShipName;
    }

    public void setInShipName(String inShipName) {
        this.inShipName = inShipName;
    }

    public float getInTotal() {
        return inTotal;
    }

    public void setInTotal(float inTotal) {
        this.inTotal = inTotal;
    }
    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(List<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "invoiceType=" + invoiceType +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", receivableOffset=" + receivableOffset +
                ", inName='" + inName + '\'' +
                ", inDate=" + inDate +
                ", inShipName='" + inShipName + '\'' +
                ", inTotal=" + inTotal +
                ", lignesCommande=" + lignesCommande +
                '}';
    }
}
