package com.example.application.backend.controller;

import com.example.application.backend.domain.entity.Commande;
import com.example.application.backend.domain.entity.LigneCommande;
import com.example.application.backend.dto.CommandeDto;
import com.example.application.backend.dto.LigneDto;
import com.example.application.backend.mapper.CommandeMapper;
import com.example.application.backend.mapper.LigneMapper;
import com.example.application.backend.service.CommandeService;
import com.example.application.backend.service.LigneService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestProvider {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private LigneService ligneService;

    private CommandeMapper commandeMapper = Mappers.getMapper(CommandeMapper.class);

    private LigneMapper ligneMapper = Mappers.getMapper(LigneMapper.class);

    @GetMapping("/commandes")
    public List<CommandeDto> listerCommandesEncours(@RequestParam(defaultValue = "", name ="invoicenumber") String stringFilter) {

        //Pageable pageable = PageRequest.of(page, pageSize);

        List<Commande> commandeEncours = commandeService.listerCommandes(stringFilter);

        return commandeMapper.map(commandeEncours);
    }

    @GetMapping("/commande/{invoiceNumber}")
    public List<LigneDto> listerLignesCommande(@PathVariable String invoiceNumber){

        List<LigneCommande> lignes = ligneService.findLignesCommande(invoiceNumber);
        return  ligneMapper.map(lignes);
    }

}
