package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/ActivateUserServlet")
public class ActivateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<html><body>");
        pw.println("<h2>Active Users</h2>");

        @SuppressWarnings("unchecked")
        Set<String> users =
                (Set<String>) getServletContext().getAttribute("loggedUser");

        if (users == null || users.isEmpty()) {
            pw.println("<p>No active users</p>");
        } else {
            pw.println("<ul>");
            for (String u : users) {
                pw.println("<li>" + u + "</li>");
            }
            pw.println("</ul>");
        }

        pw.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
