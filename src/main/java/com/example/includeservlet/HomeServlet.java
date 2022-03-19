package com.example.includeservlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Include Servlet</title></head><body>");

        out.println("<h1> Welcome to code example for including other servlets in the output!</h1>");

        request.setAttribute(AdServlet.ATTR_AD_PARAMETER, "whatever the ad provider may need");
        request.getRequestDispatcher("/ad").include(request, response);

        out.println("</html></body>");

        out.close();
    }
}