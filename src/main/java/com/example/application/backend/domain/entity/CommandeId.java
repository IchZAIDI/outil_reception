package com.example.application.backend.domain.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class CommandeId implements Serializable {

    @Column(name="InInvoiceType")
    private int invoiceType;
    @Column(name="InInvoiceNumber")
    private String invoiceNumber;
    @Column(name="InReceivableOffset")
    private int receivableOffset;


    public CommandeId() {
    }

    public CommandeId(String invoiceNumber, int receivableOffset, int invoiceType) {
        this.invoiceNumber = invoiceNumber;
        this.receivableOffset = receivableOffset;
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
        CommandeId that = (CommandeId) o;
        return receivableOffset == that.receivableOffset && invoiceType == that.invoiceType && invoiceNumber.equals(that.invoiceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceNumber, receivableOffset, invoiceType);
    }
}
