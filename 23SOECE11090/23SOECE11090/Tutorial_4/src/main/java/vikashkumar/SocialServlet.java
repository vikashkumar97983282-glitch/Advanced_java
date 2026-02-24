package vikashkumar;

//package RAM_23SOECE11606;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SocialServlet")
public class SocialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// In-memory storage (DB simulation)
	static List<Post> postList = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		displayPosts(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String action = request.getParameter("action");

		// CREATE
		if ("create".equals(action)) {
			String content = request.getParameter("content");
			String time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
			postList.add(new Post(content, time));
		}

		// UPDATE
		if ("update".equals(action)) {
			int index = Integer.parseInt(request.getParameter("id"));
			String newContent = request.getParameter("content");

			if(index >= 0 && index < postList.size()) {
				Post p = postList.get(index);
				p.content = newContent; // update content
			}
		}

		// DELETE
		if ("delete".equals(action)) {
			int index = Integer.parseInt(request.getParameter("id"));
			if(index >= 0 && index < postList.size()) {
				postList.remove(index);
			}
		}

		displayPosts(request, response);
	}

	// READ (Display posts)
	private void displayPosts(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < postList.size(); i++) {
			Post p = postList.get(i);

			sb.append("<div class='post'>");

			// UPDATE FORM
			sb.append("<form method='post' action='SocialServlet'>");
			sb.append("<input type='hidden' name='action' value='update'>");
			sb.append("<input type='hidden' name='id' value='" + i + "'>");

			sb.append("<textarea name='content' style='width:100%;height:60px;'>"+p.content+"</textarea><br>");
			sb.append("<small>Posted at: " + p.time + "</small><br><br>");
			sb.append("<button type='submit'>Update</button>");
			sb.append("</form>");

			// DELETE FORM
			sb.append("<form method='post' action='SocialServlet' style='margin-top:5px;'>");
			sb.append("<input type='hidden' name='action' value='delete'>");
			sb.append("<input type='hidden' name='id' value='" + i + "'>");
			sb.append("<button style='background:red;'>Delete</button>");
			sb.append("</form>");

			sb.append("</div>");
		}

		request.setAttribute("posts", sb.toString());
		RequestDispatcher rd = request.getRequestDispatcher("Social.jsp");
		rd.forward(request, response);
	}
}
