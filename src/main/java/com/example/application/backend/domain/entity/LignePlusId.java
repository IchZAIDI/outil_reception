package com.example.application.backend.domain.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class LignePlusId implements Serializable {

    @Column(name="TYPE_TRANSACTION")
    private int transactionType;

    @Column(name="NO_TRANSACTION")
    private String transactionNumber;

    @Column(name="RECEVABLE")
    private int receivable;

    @Column(name="NO_LIGNE")
    private int lineNumber;

    public LignePlusId() {
    }

    public LignePlusId(int invoiceType, String invoiceNumber, int receivableOffset, int lineNumber) {
        this.transactionType = invoiceType;
        this.transactionNumber = invoiceNumber;
        this.receivable = receivableOffset;
        this.lineNumber = lineNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LignePlusId that = (LignePlusId) o;
        return transactionType == that.transactionType && receivable == that.receivable && lineNumber == that.lineNumber && transactionNumber.equals(that.transactionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionType, transactionNumber, receivable, lineNumber);
    }
}
