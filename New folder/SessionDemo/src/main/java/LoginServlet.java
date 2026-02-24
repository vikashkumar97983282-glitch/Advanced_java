

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		// validation username and password
		if("admin".equals(username)&&"12345".equals(password))
		{
			LocalDateTime now=LocalDateTime.now();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String currentlogintime=now.format(formatter);
			
			// start the session implement
			HttpSession session=request.getSession();
			ArrayList<String>loginhistory=(ArrayList<String>)session.getAttribute(loginhistory);
			if(loginhistory==null)
			{
				loginhistory=new ArrayList<>();
			}
			
			loginhistory.add(currentlogintime);
			session.setAttribute("loginhistory",loginhistory);
			request.setAttribute("username", username);
			//
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
			
		}
		else
		{
			//invalid login
			response.getWriter().println("invalid username and password <a href=index.jsp>try again</a>");
			
		}
			
			
			
			
		}
	}
}
