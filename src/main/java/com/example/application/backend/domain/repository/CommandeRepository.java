package com.example.application.backend.domain.repository;

import com.example.application.backend.domain.entity.Commande;
import com.example.application.backend.domain.entity.CommandeId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, CommandeId> {

    @Query(value = "SELECT DISTINCT(FAE.InInvoiceNumber)," +
            "       FAE.InReceivableOffset, FAE.InCustomerSupplierNumber, " +
            "       FAE.InName, FAE.InDate, FAE.InInvoiceTotal, FAE.InShipName, FAE.InInvoiceType " +
            "FROM Facturation_Acomba_Entetes FAE " +
            "INNER JOIN Facturation_Acomba_Lignes FAL ON " +
            "( " +
            "   FAL.InInvoiceNumber = FAE.InInvoiceNumber AND " +
            "   FAL.InInvoiceType = FAE.InInvoiceType AND " +
            "   FAL.InReceivableOffset = FAE.InReceivableOffset " +
            ") " +
            "WHERE FAE.InInvoiceType = 5 " +
            "AND FAE.InReceivableOffset IN (0,1)"+
            "AND ROUND(FAL.ILOrderedQty - FAL.ILInvoicedQty, 6) > 0" +
            "ORDER BY FAE.InInvoiceNumber ",
            countQuery = "SELECT DISTINCT(FAE.InInvoiceNumber)," +
                    "       FAE.InReceivableOffset, FAE.InCustomerSupplierNumber, " +
                    "       FAE.InName, FAE.InDate, FAE.InInvoiceTotal, FAE.InShipName, FAE.InInvoiceType " +
                    "FROM Facturation_Acomba_Entetes FAE " +
                    "INNER JOIN Facturation_Acomba_Lignes FAL ON " +
                    "( " +
                    "   FAL.InInvoiceNumber = FAE.InInvoiceNumber AND " +
                    "   FAL.InInvoiceType = FAE.InInvoiceType AND " +
                    "   FAL.InReceivableOffset = FAE.InReceivableOffset " +
                    ") " +
                    "WHERE FAE.InInvoiceType = 5 " +
                    "AND FAE.InReceivableOffset IN (0,1)"+
                    "AND ROUND(FAL.ILOrderedQty - FAL.ILInvoicedQty, 6) > 0" +
                    "ORDER BY FAE.InInvoiceNumber ",
            nativeQuery = true)
    Page<Commande> findEncours(Pageable pageable);

    @Query(value = "SELECT DISTINCT(FAE.InInvoiceNumber)," +
            "       FAE.InReceivableOffset, FAE.InCustomerSupplierNumber, " +
            "       FAE.InName, FAE.InDate, FAE.InInvoiceTotal, FAE.InShipName, FAE.InInvoiceType " +
            "FROM Facturation_Acomba_Entetes FAE " +
            "INNER JOIN Facturation_Acomba_Lignes FAL ON " +
            "( " +
            "   FAL.InInvoiceNumber = FAE.InInvoiceNumber AND " +
            "   FAL.InInvoiceType = FAE.InInvoiceType AND " +
            "   FAL.InReceivableOffset = FAE.InReceivableOffset " +
            ") " +
            "WHERE FAE.InInvoiceType = 5 " +
            "AND FAE.InReceivableOffset IN (0,1)"+
            "AND ROUND(FAL.ILOrderedQty - FAL.ILInvoicedQty, 6) > 0" +
            "ORDER BY FAE.InInvoiceNumber ",
            nativeQuery = true)
    List<Commande> findEncours();

    @Query(value = "SELECT DISTINCT(FAE.InInvoiceNumber)," +
            "       FAE.InInvoiceNumber, FAE.InReceivableOffset, FAE.InCustomerSupplierNumber, " +
            "       FAE.InName, FAE.InDate, FAE.InInvoiceTotal, FAE.InShipName, FAE.InInvoiceType " +
            "FROM Facturation_Acomba_Entetes FAE " +
            "INNER JOIN Facturation_Acomba_Lignes FAL ON " +
            "( " +
            "   FAL.InInvoiceNumber = FAE.InInvoiceNumber AND " +
            "   FAL.InInvoiceType = FAE.InInvoiceType AND " +
            "   FAL.InReceivableOffset = FAE.InReceivableOffset " +
            ") " +
            "WHERE FAE.InInvoiceType = 5 " +
            "AND FAE.InInvoiceNumber LIKE :invoiceNumber% " +
            "AND ROUND(FAL.ILOrderedQty - FAL.ILInvoicedQty, 6) > 0" +
            "ORDER BY FAE.InInvoiceNumber ",
            countQuery = "SELECT DISTINCT(FAE.InInvoiceNumber)," +
                    "       FAE.InInvoiceNumber, FAE.InReceivableOffset, FAE.InCustomerSupplierNumber, " +
                    "       FAE.InName, FAE.InDate, FAE.InInvoiceTotal, FAE.InShipName, FAE.InInvoiceType " +
                    "FROM Facturation_Acomba_Entetes FAE " +
                    "INNER JOIN Facturation_Acomba_Lignes FAL ON " +
                    "( " +
                    "   FAL.InInvoiceNumber = FAE.InInvoiceNumber AND " +
                    "   FAL.InInvoiceType = FAE.InInvoiceType AND " +
                    "   FAL.InReceivableOffset = FAE.InReceivableOffset " +
                    ") " +
                    "WHERE FAE.InInvoiceType = 5 " +
                    "AND FAE.InInvoiceNumber LIKE :invoiceNumber% " +
                    "AND ROUND(FAL.ILOrderedQty - FAL.ILInvoicedQty, 6) > 0" +
                    "ORDER BY FAE.InInvoiceNumber ",
            nativeQuery = true)
    Page<Commande> findEncoursByInvoiceNumber(@Param("invoiceNumber") String invoiceNumber, Pageable pageable);

    @Query(value = "SELECT DISTINCT(FAE.InInvoiceNumber)," +
            "       FAE.InInvoiceNumber, FAE.InReceivableOffset, FAE.InCustomerSupplierNumber, " +
            "       FAE.InName, FAE.InDate, FAE.InInvoiceTotal, FAE.InShipName, FAE.InInvoiceType " +
            "FROM Facturation_Acomba_Entetes FAE " +
            "INNER JOIN Facturation_Acomba_Lignes FAL ON " +
            "( " +
            "   FAL.InInvoiceNumber = FAE.InInvoiceNumber AND " +
            "   FAL.InInvoiceType = FAE.InInvoiceType AND " +
            "   FAL.InReceivableOffset = FAE.InReceivableOffset " +
            ") " +
            "WHERE FAE.InInvoiceType = 5 " +
            "AND FAE.InInvoiceNumber LIKE :invoiceNumber% " +
            "AND ROUND(FAL.ILOrderedQty - FAL.ILInvoicedQty, 6) > 0" +
            "ORDER BY FAE.InInvoiceNumber ",
            nativeQuery = true)
    List<Commande> findEncoursByInvoiceNumber(@Param("invoiceNumber") String invoiceNumber);


}
