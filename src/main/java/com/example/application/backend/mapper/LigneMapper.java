package com.example.application.backend.mapper;

import com.example.application.backend.domain.entity.LigneCommande;
import com.example.application.backend.domain.entity.LignePlus;
import com.example.application.backend.dto.LigneDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Mapper
public interface LigneMapper {

    @Mappings({
            @Mapping(target="id", source="entity.lineNumber"),
            @Mapping(target="commandeId", source="entity.invoiceNumber"),
            @Mapping(target="receivableOffset", source="entity.receivableOffset"),
            @Mapping(target="invoiceType", source="entity.invoiceType"),
            @Mapping(target="description", source="entity.description"),
            @Mapping(target="productNumber", source="entity.productNumber"),
            @Mapping(target="productSupplierNumber", source="entity.productSupplierNumber"),
            @Mapping(target="invoicedQty", source="entity.invoicedQty"),
            @Mapping(target="orderedQty", source="entity.orderedQty"),
            @Mapping(target = "noAppel", source="entity", qualifiedByName = "noAppel"),
            @Mapping(target = "entrepot", source="entity", qualifiedByName = "entrepot"),
            @Mapping(target = "dateLivraison", source="entity", qualifiedByName = "dateLivraison"),
            @Mapping(target = "numeroAssemblage", source="entity", qualifiedByName = "numeroAssemblage"),

    })
    LigneDto ligneToLigneDto(LigneCommande entity);

    @Named("numeroAssemblage")
    default String numeroAssemblageMapper(LigneCommande item) {
        if(CollectionUtils.isEmpty(item.getLignePlus()) || item.getLignePlus().get(0).getDetailOrdreAssemblage() == null){
            return "";
        }
        else
            return item.getLignePlus().get(0).getDetailOrdreAssemblage().getNumeroAssemblage();
    }

    @Named("noAppel")
    default int noAppelMapper(LigneCommande item) {
        if(CollectionUtils.isEmpty(item.getLignePlus())){
            return 0;
        }
        else
            return item.getLignePlus().get(0).getNoAppel();
    }

    @Named("entrepot")
    default String entrepotMapper(LigneCommande item) {
        if(CollectionUtils.isEmpty(item.getLignePlus()) || item.getLignePlus().get(0).getEntrepot() == null){
            return "";
        }
        else
            return item.getLignePlus().get(0).getEntrepot().getCodeEntropot();
    }

    @Named("dateLivraison")
    default Date dateLivraisonMapper(LigneCommande item) {
        if(CollectionUtils.isEmpty(item.getLignePlus())){
            return null;
        }
        else
            return item.getLignePlus().get(0).getDateLivraison();
    }

    List<LigneDto> map(List<LigneCommande> ligneCommandes);
}
