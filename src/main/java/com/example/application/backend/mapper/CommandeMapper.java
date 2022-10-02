package com.example.application.backend.mapper;

import com.example.application.backend.domain.entity.Commande;
import com.example.application.backend.dto.CommandeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface CommandeMapper {

    @Mappings({
            @Mapping(target="id", source="entity.invoiceNumber"),
            @Mapping(target="inName", source="entity.inName"),
            @Mapping(target="inDate", source="entity.inDate"),
            @Mapping(target="inShipName", source="entity.inShipName"),
            @Mapping(target="inTotal", source="entity.inTotal"),
            @Mapping(target="receivableOffset", source="entity.receivableOffset"),
            @Mapping(target="invoiceType", source="entity.invoiceType")
    })
    CommandeDto commandeToCommandeDto(Commande entity);

    List<CommandeDto> map(List<Commande> commandes);
}
