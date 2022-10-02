package com.example.application.backend.service;

import com.example.application.backend.domain.entity.LigneCommande;

import java.util.List;

public interface LigneService {

    List<LigneCommande> findLignesCommande(String invoiceNumber);
}
