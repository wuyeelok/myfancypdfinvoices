package com.ken;

public class InvoiceService {

    public Invoice create(String userId, Integer amount) {
        return new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
    }
}
