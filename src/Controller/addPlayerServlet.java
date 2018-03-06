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
 * Servlet implementation class addPlayerServlet
 */
@WebServlet("/addPlayerServlet")
public class addPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public addPlayerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String screenName = request.getParameter("screenName");
		//int teamId = Integer.parseInt(request.getParameter("teamId"));

		//Team team = new Team();
		//String teamName = request.getParameter("teamName");
		//String teamType = request.getParameter("teamType");
		//String preferredNight = request.getParameter("preferredNight");
		Team nt = new Team("cubs", "baseball", "mon");
		TeamHelper teamHelp = new TeamHelper();
		//team = teamDao.searchForTeamById(teamId);
		teamHelp.insertTeam(nt);
		
		Player player = new Player(firstName, lastName, phoneNumber, screenName, nt);
		PlayerHelper playerDao = new PlayerHelper();
		playerDao.insertPlayer(player);
		
		getServletContext().getRequestDispatcher("/addPlayer.jsp").forward(request, response);
	}


	}

