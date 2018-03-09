package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Player;
import Model.Team;

/**
 * Servlet implementation class viewAllTeamsServlet
 */
@WebServlet("/viewAllTeamsServlet")
public class viewAllTeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllTeamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TeamHelper th = new TeamHelper();
		String act = request.getParameter("doThisToItem");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/buildTeamListServlet").forward(request, response);
			}
		else if (act.equals("Delete Selected Team")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Team teamToDelete = th.searchForTeamById(tempId);
			th.deleteTeam(teamToDelete);
			
			getServletContext().getRequestDispatcher("/buildTeamListServlet").forward(request, response);
			}
		else if (act.equals("Add New Team")) {
			getServletContext().getRequestDispatcher("/addTeam.html").forward(request, response);
		}
	}

}
