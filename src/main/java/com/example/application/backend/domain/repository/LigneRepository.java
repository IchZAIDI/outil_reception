package com.example.application.backend.domain.repository;

import com.example.application.backend.domain.entity.LigneCommande;
import com.example.application.backend.domain.entity.LigneCommandeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneRepository extends JpaRepository<LigneCommande, LigneCommandeId> {

    @Query(value = "SELECT " +
            "       FAL.InInvoiceNumber, FAL.InReceivableOffset, FAL.InInvoiceType, " +
            "       FAL.ILLineNumber, FAL.ILDescription, FAL.ILProductNumber, " +
            "       FAL.ILProductSupplierNumber, FAL.ILInvoicedQty, FAL.ILOrderedQty " +
            "FROM Facturation_Acomba_Lignes FAL " +
            "WHERE FAL.InInvoiceNumber = :invoiceNumber " +
            "AND FAL.InReceivableOffset IN (0,1) " +
            "AND FAL.InInvoiceType = 5 " +
            "AND FAL.ILLineNumber NOT IN (991,992)" +
            "AND FAL.ILOrderedQty > 0",
            nativeQuery = true)
    List<LigneCommande> findByInvoiceNumber(@Param("invoiceNumber") String invoiceNumber);

}
