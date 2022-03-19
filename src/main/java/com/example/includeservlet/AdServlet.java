package com.example.includeservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GoogleAdsServlet", value = "/ad")
public class AdServlet extends HttpServlet {
    public static final String ATTR_AD_PARAMETER = "ad-param";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String attribute = (String) request.getAttribute(ATTR_AD_PARAMETER);

        if (attribute == null) {
            // If no attribute was sent this means someone may be accidentally or intentionally trying to access
            // this address directly, so we redirect to home-page if this is an HTML servlet or send an error
            // message in JSON if this is an API endpoint.
            response.sendRedirect("/");
        }

        PrintWriter out = response.getWriter();

        out.println("<div class=\"ad-container\">");

        String adHtml = "This is where the ad will be.";
        // Contact ad provider service, send whatever data it requires and receive the add HTML code.
        // Print the received HTML here.
        out.println(adHtml);
        out.println("</div>");
    }
}
