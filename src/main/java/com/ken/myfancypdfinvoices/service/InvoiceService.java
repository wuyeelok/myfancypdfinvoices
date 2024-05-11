package com.ken.myfancypdfinvoices.service;

import com.ken.myfancypdfinvoices.context.Application;
import com.ken.myfancypdfinvoices.model.Invoice;
import com.ken.myfancypdfinvoices.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    private final List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> findAll() {
        return this.invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = Application.userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        this.invoices.add(invoice);
        return invoice;
    }
}
