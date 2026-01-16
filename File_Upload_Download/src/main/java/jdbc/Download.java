package jdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Download")
public class Download extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String QUERY_ALL =
            "SELECT id, file_name FROM file_upload";

    private static final String QUERY_BY_ID =
            "SELECT * FROM file_upload WHERE id=?";

    private static final String QUERY_DELETE_BY_ID =
            "DELETE FROM file_upload WHERE id=?";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String action = request.getParameter("action");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee",
                    "root",
                    ""
            );

            /* ---------------- DELETE FILE ---------------- */
            if ("delete".equals(action) && id != null) {

                PreparedStatement ps = con.prepareStatement(QUERY_DELETE_BY_ID);
                ps.setInt(1, Integer.parseInt(id));
                ps.executeUpdate();
                ps.close();

                response.sendRedirect("Download");
                return;
            }

            /* ---------------- FILE LIST ---------------- */
            if (id == null) {

                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();

                pw.println("<html><body>");
                pw.println("<h2>File List</h2>");
                pw.println("<table border='1'>");
                pw.println("<tr>");
                pw.println("<th>ID</th>");
                pw.println("<th>File Name</th>");
                pw.println("<th>Download</th>");
                pw.println("<th>Delete</th>");
                pw.println("</tr>");

                PreparedStatement ps = con.prepareStatement(QUERY_ALL);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int fileId = rs.getInt("id");

                    pw.println("<tr>");
                    pw.println("<td>" + fileId + "</td>");
                    pw.println("<td>" + rs.getString("file_name") + "</td>");
                    pw.println("<td><a href='Download?id=" + fileId + "'>Download</a></td>");
                    pw.println("<td>");
                    pw.println("<a href='Download?action=delete&id=" + fileId +
                               "' onclick=\"return confirm('Are you sure?')\">Delete</a>");
                    pw.println("</td>");
                    pw.println("</tr>");
                }

                pw.println("</table>");
                pw.println("</body></html>");

                rs.close();
                ps.close();
            }

            /* ---------------- DOWNLOAD FILE ---------------- */
            else {

                PreparedStatement ps = con.prepareStatement(QUERY_BY_ID);
                ps.setInt(1, Integer.parseInt(id));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    response.setContentType(rs.getString("file_type"));
                    response.setHeader(
                            "Content-Disposition",
                            "attachment; filename=\"" + rs.getString("file_name") + "\""
                    );

                    InputStream in = rs.getBinaryStream("file_data");
                    ServletOutputStream out = response.getOutputStream();

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }

                    in.close();
                    out.flush();
                }

                rs.close();
                ps.close();
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
