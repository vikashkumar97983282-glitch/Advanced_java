

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class method
 */
@WebServlet("/method")
public class method extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public method() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String configvalue=getServletConfig().getInitParameter("configname");
		
		PrintWriter pw = response.getWriter();
		pw.print("<p>config value </p>"+configvalue);
		String contextparam=getServletContext().getInitParameter(configvalue);
		
		pw.print("<p>contextparam </p>"+contextparam);
		pw.print("method of servlet");
		String useragent = request.getHeader("Accept");
		pw.print("<p>method name </p>"+useragent);
		String method=request.getMethod();
		pw.print("<p>method name</p>"+method);
		
		//response.setHeader("Refresh","20:URL = index.jsp");
		response.sendRedirect("index.jsp");
		//getHeader() = Accept, Authorization, Referer:address of webpages, User-Agent:client browser
	}


}
