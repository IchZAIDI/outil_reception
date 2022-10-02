package com.example.application.backend.service;

import com.example.application.backend.domain.entity.Commande;

import java.util.List;
import java.util.stream.Stream;

public interface CommandeService {

    Stream<Commande> fetchCommandes(String searchTerm, int page, int pageSize);

    List<Commande> listerCommandes(String stringFilter);
}
