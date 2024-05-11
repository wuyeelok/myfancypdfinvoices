package com.ken.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ken.myfancypdfinvoices.service.InvoiceService;
import com.ken.myfancypdfinvoices.service.UserService;

public class Application {

    public static final InvoiceService invoiceService = new InvoiceService();
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final UserService userService = new UserService();
}

