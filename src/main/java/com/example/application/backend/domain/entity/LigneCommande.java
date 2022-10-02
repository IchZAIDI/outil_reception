package com.example.application.backend.domain.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@IdClass(LigneCommandeId.class)
@Table(name = "FACTURATION_ACOMBA_LIGNES")
public class LigneCommande {

    @Column(name="InInvoiceType")
    @Id
    private int invoiceType;

    @Column(name="InInvoiceNumber")
    @Id
    private String invoiceNumber;

    @Column(name="InReceivableOffset")
    @Id
    private int receivableOffset;

    @Column(name="ILLineNumber")
    @Id
    private int lineNumber;

    @Column(name="ILDescription")
    private String description;

    @Column(name="ILProductNumber")
    private String productNumber;

    @Column(name="ILProductSupplierNumber")
    private String productSupplierNumber;

    @Column(name="ILInvoicedQty")
    private Float invoicedQty;

    @Column(name="ILOrderedQty")
    private Float orderedQty;
    @JsonManagedReference
    @OneToMany(mappedBy = "ligneCommande",fetch = FetchType.EAGER)
    private List<LignePlus> lignePlus= new ArrayList<>();

    public LigneCommande() {
    }

    public LigneCommande(String description, String productNumber, String productSupplierNumber, Float invoicedQty, Float orderedQty, List<LignePlus> lignePlus) {
       this.description = description;
        this.productNumber = productNumber;
        this.productSupplierNumber = productSupplierNumber;
        this.invoicedQty = invoicedQty;
        this.orderedQty = orderedQty;
        this.lignePlus = lignePlus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductSupplierNumber() {
        return productSupplierNumber;
    }

    public void setProductSupplierNumber(String productSupplierNumber) {
        this.productSupplierNumber = productSupplierNumber;
    }

    public Float getInvoicedQty() {
        return invoicedQty;
    }

    public void setInvoicedQty(Float invoicedQty) {
        this.invoicedQty = invoicedQty;
    }

    public Float getOrderedQty() {
        return orderedQty;
    }

    public void setOrderedQty(Float orderedQty) {
        this.orderedQty = orderedQty;
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

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public List<LignePlus> getLignePlus() {
        return lignePlus;
    }

    public void setLignePlus(List<LignePlus> lignePlus) {
        this.lignePlus = lignePlus;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "invoiceType=" + invoiceType +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", receivableOffset=" + receivableOffset +
                ", lineNumber=" + lineNumber +
                ", description='" + description + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", productSupplierNumber='" + productSupplierNumber + '\'' +
                ", invoicedQty=" + invoicedQty +
                ", orderedQty=" + orderedQty +
                ", lignePlus=" + lignePlus +
                '}';
    }
}
