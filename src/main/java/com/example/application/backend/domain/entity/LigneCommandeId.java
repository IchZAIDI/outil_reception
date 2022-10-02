package com.example.application.backend.domain.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class LigneCommandeId implements Serializable {

    @Column(name="InInvoiceType")
    private int invoiceType;
    @Column(name="InInvoiceNumber")
    private String invoiceNumber;
    @Column(name="InReceivableOffset")
    private int receivableOffset;
    @Column(name="ILLineNumber")
    private int lineNumber;

    public LigneCommandeId() {
    }

    public LigneCommandeId(String invoiceNumber, int receivableOffset, int invoiceType, int lineNumber) {
        this.invoiceNumber = invoiceNumber;
        this.receivableOffset = receivableOffset;
        this.invoiceType = invoiceType;
        this.lineNumber = lineNumber;
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

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommandeId that = (LigneCommandeId) o;
        return receivableOffset == that.receivableOffset && invoiceType == that.invoiceType && lineNumber == that.lineNumber && invoiceNumber.equals(that.invoiceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceNumber, receivableOffset, invoiceType, lineNumber);
    }
}
