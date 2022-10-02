package com.example.application.backend.service;


import com.example.application.backend.domain.entity.LigneCommande;
import com.example.application.backend.domain.repository.LigneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneServiceImpl implements LigneService {

    @Autowired
    LigneRepository ligneRepository;


    @Override
    public List<LigneCommande> findLignesCommande(String invoiceNumber) {
        return ligneRepository.findByInvoiceNumber(invoiceNumber);
    }
}
