package com.example.application.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(LignePlusId.class)
@Table(name = "DPLUS_FACTURATION_LIGNES")
public class LignePlus {

    @Column(name="TYPE_TRANSACTION")
    @Id
    private int transactionType;

    @Column(name="NO_TRANSACTION")
    @Id
    private String transactionNumber;

    @Column(name="RECEVABLE")
    @Id
    private int receivable;

    @Column(name="NO_LIGNE")
    @Id
    private int lineNumber;

    @Column(name="NO_APPEL")
    private int noAppel;

    @OneToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "ID_ENTREPOT",  insertable=false, updatable=false)
    private Entrepot entrepot;

    @Column(name="DATE_LIVRAISON")
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="TYPE_TRANSACTION", referencedColumnName = "InInvoiceType", insertable=false, updatable=false),
            @JoinColumn(name="NO_TRANSACTION", referencedColumnName = "InInvoiceNumber", insertable=false, updatable=false),
            @JoinColumn(name="RECEVABLE", referencedColumnName = "InReceivableOffset", insertable=false, updatable=false),
            @JoinColumn(name="NO_LIGNE",referencedColumnName = "ILLineNumber", insertable=false, updatable=false)
    })
    private LigneCommande ligneCommande;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "NoSeq_oad", referencedColumnName = "NoSeq_oad", insertable=false, updatable=false)
    private DetailOrdreAssemblage detailOrdreAssemblage;

    public LignePlus() {
    }

    public LignePlus(int noAppel, Entrepot entrepot, Date dateLivraison, LigneCommande ligneCommande, DetailOrdreAssemblage detailOrdreAssemblage) {
        this.noAppel = noAppel;
        this.entrepot = entrepot;
        this.dateLivraison = dateLivraison;
        this.ligneCommande = ligneCommande;
        this.detailOrdreAssemblage = detailOrdreAssemblage;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getReceivable() {
        return receivable;
    }

    public void setReceivable(int receivable) {
        this.receivable = receivable;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getNoAppel() {
        return noAppel;
    }

    public void setNoAppel(int noAppel) {
        this.noAppel = noAppel;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public DetailOrdreAssemblage getDetailOrdreAssemblage() {
        return detailOrdreAssemblage;
    }

    public void setDetailOrdreAssemblage(DetailOrdreAssemblage detailOrdreAssemblage) {
        this.detailOrdreAssemblage = detailOrdreAssemblage;
    }

    @Override
    public String toString() {
        return "LignePlus{" +
                "transactionType=" + transactionType +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", receivable=" + receivable +
                ", lineNumber=" + lineNumber +
                ", noAppel=" + noAppel +
                ", entrepot=" + entrepot +
                ", dateLivraison=" + dateLivraison +
                ", ligneCommande=" + ligneCommande +
                ", detailOrdreAssemblage=" + detailOrdreAssemblage +
                '}';
    }
}
