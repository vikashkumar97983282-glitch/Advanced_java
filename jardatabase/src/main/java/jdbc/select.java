package jdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Select")
public class select extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // 🔍 Get search parameter
        String search = request.getParameter("search");

        // 🔍 Search form
        pw.println("<form method='get' action='Select'>");
        pw.println("<input type='text' name='search' placeholder='Search by ID or Name'>");
        pw.println("<input type='submit' value='Search'>");
        pw.println("</form><br>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee",
                    "root",
                    ""
            );

            PreparedStatement ps;

            if (search != null && !search.trim().isEmpty()) {
                ps = con.prepareStatement(
                        "SELECT * FROM empdata WHERE empid=? OR empname LIKE ?"
                );
                ps.setInt(1, Integer.parseInt(search));
                ps.setString(2, "%" + search + "%");
            } else {
                ps = con.prepareStatement("SELECT * FROM empdata");
            }

            ResultSet rs = ps.executeQuery();

            // 📋 Table
            pw.println("<table border='1'>");
            pw.println("<tr>");
            pw.println("<th>Emp ID</th>");
            pw.println("<th>Emp Name</th>");
            pw.println("<th>Mobile</th>");
            pw.println("<th>Delete</th>");
            pw.println("<th>Edit</th>");
            pw.println("</tr>");

            while (rs.next()) {
                pw.println("<tr>");
                pw.println("<td>" + rs.getInt(1) + "</td>");
                pw.println("<td>" + rs.getString(2) + "</td>");
                pw.println("<td>" + rs.getString(3) + "</td>");

                pw.println("<td><a href='Delete?id=" + rs.getInt(1) + "'>Delete</a></td>");
                pw.println("<td><a href='EditSelect?id=" + rs.getInt(1) + "'>Edit</a></td>");
                pw.println("</tr>");
            }

            pw.println("</table>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        pw.println("<br><a href='index.jsp'>Home</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
