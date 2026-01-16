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

@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ✅ Correct SQL query
    private static final String QUERY =
            "UPDATE empdata SET empname=?, mobileno=? WHERE empid=?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String uname = request.getParameter("username");
        String mno = request.getParameter("mobileno");
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            // ✅ Correct driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee",
                    "root",
                    ""
            );

            PreparedStatement ps = con.prepareStatement(QUERY);

            // ✅ Correct parameter order
            ps.setString(1, uname);
            ps.setString(2, mno);
            ps.setInt(3, id);

            int count = ps.executeUpdate();

            if (count == 1) {
                pw.println("<h1>Data Updated Successfully</h1>");
            } else {
                pw.println("<h1>Update Failed</h1>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
