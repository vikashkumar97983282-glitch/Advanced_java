package jdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
@MultipartConfig(maxFileSize=1024*1024*20)
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		Part filepart=request.getPart("file");
		String filename=filepart.getSubmittedFileName();
		String filetype=filepart.getContentType();
		InputStream filedata=filepart.getInputStream();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			String sql="insert into file_upload (file_name,file_type,file_data) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, filename);
			ps.setString(2, filetype);
			ps.setBlob(3, filedata);
			ps.executeUpdate();
			con.close();
			response.sendRedirect("index.jsp");
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

}
