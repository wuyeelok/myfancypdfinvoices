package com.ken;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyFancyPdfInvoicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print(
                """
                        <html>
                        <body>
                        <h1>Hello World</h1>
                        <p>This is my very first, embedded Tomcat, HTML Page!</p>
                        </body>
                        </html>""");
    }
}
