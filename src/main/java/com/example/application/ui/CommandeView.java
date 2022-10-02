package com.example.application.ui;

import com.example.application.backend.domain.entity.Commande;
import com.example.application.backend.service.CommandeService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Liste commandes en cours")
@Route(value = "lazy")
public class CommandeView extends VerticalLayout {


    private CommandeService commandeService;

    private Grid<Commande> grid = new Grid<>(Commande.class);

   TextField filterText = new TextField();


    public CommandeView(CommandeService commandeService) {

        this.commandeService = commandeService;
        addClassName("list-view");
        setSizeFull();

        configureGrid();

        Div content = new Div(grid);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolbar(), content);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("commande-grid");
        grid.setSizeFull();
        grid.setPageSize(5);
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.setColumns("invoiceNumber", "inName", "inShipName", "inTotal");
        grid.getColumnByKey("invoiceNumber").setHeader("Numero commande");
        grid.getColumnByKey("inName").setHeader("Fournisseur");
        grid.getColumnByKey("inShipName").setHeader("Expediee a");
        grid.getColumnByKey("inTotal").setHeader("Total");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        grid.addColumn(bean -> formatter.format(bean.getInDate()))
                .setComparator((o1, o2) -> o1.getInDate().compareTo(o2.getInDate()))
                .setHeader("Date");
    }

    private void updateList() {
        grid.setItems(query -> commandeService.fetchCommandes(filterText.getValue(), query.getPage(), query.getPageSize()));
    }

    /**
     * A method to convert given Vaadin sort hints to Spring Data specific sort
     * instructions.
     *
     * @param vaadinSortOrders a list of Vaadin QuerySortOrders to convert to
     * @return the Sort object for Spring Data repositories
     */
    public static Sort toSpringDataSort(List<QuerySortOrder> vaadinSortOrders) {
        return Sort.by(
                vaadinSortOrders.stream()
                        .map(sortOrder ->
                                sortOrder.getDirection() == SortDirection.ASCENDING ?
                                        Sort.Order.asc(sortOrder.getSorted()) : // (5)
                                        Sort.Order.desc(sortOrder.getSorted())
                        )
                        .collect(Collectors.toList())
        );
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
