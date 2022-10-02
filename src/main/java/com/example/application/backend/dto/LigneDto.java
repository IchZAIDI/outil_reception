package com.example.application.backend.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LigneDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String commandeId;
    private String id;
    private int receivableOffset;
    private int invoiceType;
    private String description;
    private String productNumber;
    private String productSupplierNumber;
    private Float invoicedQty;
    private Float orderedQty;
    private Float recievedQty = 0.0f;
    private int noAppel;
    private String entrepot;
    private Date dateLivraison;

    private String numeroAssemblage;

    public LigneDto() {
    }

    public LigneDto(String commandeId, String id, int receivableOffset, int invoiceType, String description, String productNumber, String productSupplierNumber, Float invoicedQty, Float orderedQty, Float recievedQty, int noAppel, String entrepot, Date dateLivraison, String numeroAssemblage) {
        this.commandeId = commandeId;
        this.id = id;
        this.receivableOffset = receivableOffset;
        this.invoiceType = invoiceType;
        this.description = description;
        this.productNumber = productNumber;
        this.productSupplierNumber = productSupplierNumber;
        this.invoicedQty = invoicedQty;
        this.orderedQty = orderedQty;
        this.recievedQty = recievedQty;
        this.noAppel = noAppel;
        this.entrepot = entrepot;
        this.dateLivraison = dateLivraison;
        this.numeroAssemblage = numeroAssemblage;
    }

    public String getNumeroAssemblage() {
        return numeroAssemblage;
    }

    public void setNumeroAssemblage(String numeroAssemblage) {
        this.numeroAssemblage = numeroAssemblage;
    }

    public int getNoAppel() {
        return noAppel;
    }

    public void setNoAppel(int noAppel) {
        this.noAppel = noAppel;
    }

    public String getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(String entrepot) {
        this.entrepot = entrepot;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(String commandeId) {
        this.commandeId = commandeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getReceivableOffset() {
        return receivableOffset;
    }

    public void setReceivableOffset(int receivableOffset) {
        this.receivableOffset = receivableOffset;
    }

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
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

    public Float getRecievedQty() {
        return recievedQty;
    }

    public void setRecievedQty(Float recievedQty) {
        this.recievedQty = recievedQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneDto that = (LigneDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
