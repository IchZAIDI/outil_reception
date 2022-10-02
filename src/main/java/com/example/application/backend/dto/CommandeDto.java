package com.example.application.backend.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CommandeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String inName;
    private Date inDate;
    private String inShipName;
    private float inTotal;
    private int receivableOffset;
    private int invoiceType;

    public CommandeDto() {
    }

    public CommandeDto(String id, String inName, Date inDate, String inShipName, float inTotal, int receivableOffset, int invoiceType) {
        this.id = id;
        this.inName = inName;
        this.inDate = inDate;
        this.inShipName = inShipName;
        this.inTotal = inTotal;
        this.receivableOffset = receivableOffset;
        this.invoiceType = invoiceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeDto that = (CommandeDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
