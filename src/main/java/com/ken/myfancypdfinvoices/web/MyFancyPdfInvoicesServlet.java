package com.ken.myfancypdfinvoices.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ken.myfancypdfinvoices.model.Invoice;
import com.ken.myfancypdfinvoices.service.InvoiceService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MyFancyPdfInvoicesServlet extends HttpServlet {

    private final InvoiceService invoiceService = new InvoiceService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/")) {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print(
                    """
                            <html>
                            <body>
                            <h1>Hello World</h1>
                            <p>This is my very first, embedded Tomcat, HTML Page!</p>
                            </body>
                            </html>""");
        } else if (req.getRequestURI().equalsIgnoreCase("/invoices")) {
            resp.setContentType("application/json; charset=UTF-8");
            List<Invoice> invoices = invoiceService.findAll();
            resp.getWriter().print(objectMapper.writeValueAsString(invoices));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/invoices")) {

            String userId = req.getParameter("user_id");
            Integer amount = Integer.valueOf(req.getParameter("amount"));

            Invoice invoice = invoiceService.create(userId, amount);

            resp.setContentType("application/json; charset=UTF-8");
            String json = new ObjectMapper().writeValueAsString(invoice);
            resp.getWriter().print(json);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
