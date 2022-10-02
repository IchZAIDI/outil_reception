package com.example.application.ui;

import com.example.application.backend.controller.RestProvider;
import com.example.application.backend.dto.CommandeDto;
import com.example.application.backend.dto.LigneDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.Date;

@PermitAll
@PageTitle("Liste commandes en cours")
@Route(value = "", layout = MainLayout.class)
public class ListCommandes extends VerticalLayout {

    private RestProvider restProvider;

    private Grid<CommandeDto> grid1 = new Grid<CommandeDto>(CommandeDto.class);
    private Grid<LigneDto> grid2 = new Grid<LigneDto>(LigneDto.class);

    TextField filterText = new TextField();


    public ListCommandes(RestProvider restProvider) {

        this.restProvider = restProvider;
        addClassName("list-view");
        setSizeFull();

        configureGrid();


        VerticalLayout content = new VerticalLayout(grid1,grid2);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolbar(), content);
        updateList();
    }

    private void configureGrid() {

        grid1.addClassName("commande-grid");
        grid1.setSizeFull();
        grid1.getColumns().forEach(col -> col.setAutoWidth(true));
        grid1.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        grid1.setColumns("id", "inDate", "inName", "inShipName","inTotal");

        grid2.addClassName("ligne-grid");
        grid2.setSizeFull();
        grid2.getColumns().forEach(col -> col.setAutoWidth(true));
        grid2.addThemeVariants(GridVariant.MATERIAL_COLUMN_DIVIDERS);
        grid2.setColumns("productNumber", "description", "productSupplierNumber", "invoicedQty","orderedQty"
        ,"noAppel","entrepot","dateLivraison","numeroAssemblage");

        grid2.getColumnByKey("productNumber").setHeader("My Caption");


        grid2.setVisible(false);

        grid1.asSingleSelect().addValueChangeListener(event -> showDetails(event.getValue()));

    }

    private void showDetails(CommandeDto commandeDto) {

        if (commandeDto == null) {
            System.out.println("Hello");
        } else {
           grid2.setItems(restProvider.listerLignesCommande(commandeDto.getId()));
           grid2.setVisible(true);
        }
    }



    private void updateList() {

        grid1.setItems(restProvider.listerCommandesEncours(filterText.getValue()));

    }

    private HorizontalLayout getToolbar() {

        filterText.setPlaceholder("Filtrer");
        filterText.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        HorizontalLayout toolbar = new HorizontalLayout(filterText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
