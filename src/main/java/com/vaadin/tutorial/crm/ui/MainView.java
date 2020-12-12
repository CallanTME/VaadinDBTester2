package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.entity.Contact;
import com.vaadin.tutorial.crm.backend.service.ContactService;

@Route("")
public class MainView extends VerticalLayout {
    private ContactService contactService;
    private Grid<Contact> grid = new Grid<>(Contact.class);
    public MainView(ContactService contactService) {
        this.contactService = contactService; 
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        add(grid);
        updateList();
    }
    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName", "email", "status");
    }
    private void updateList() {
        grid.setItems(contactService.findAll());
    }
}
