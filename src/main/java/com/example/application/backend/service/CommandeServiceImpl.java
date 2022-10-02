package com.example.application.backend.service;

import com.example.application.backend.domain.entity.Commande;
import com.example.application.backend.domain.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public Stream<Commande> fetchCommandes(String stringFilter, int page, int pageSize) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return commandeRepository.findEncours(PageRequest.of(page, pageSize)).stream();
        } else {
            return commandeRepository.findEncoursByInvoiceNumber(stringFilter, PageRequest.of(page, pageSize)).stream();
        }
    }

    @Override
    public List<Commande> listerCommandes(String stringFilter) {

        if (stringFilter == null || stringFilter.isEmpty()) {
            return commandeRepository.findEncours();
        } else {
            return commandeRepository.findEncoursByInvoiceNumber(stringFilter);
        }
    }
}
