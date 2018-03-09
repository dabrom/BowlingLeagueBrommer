package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Team;

/**
 * Servlet implementation class buildTeamListServlet
 */
@WebServlet("/buildTeamListServlet")
public class buildTeamListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buildTeamListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeamHelper th = new TeamHelper();
		request.setAttribute("allTeams", th.showAllTeams());
		if(th.showAllTeams().isEmpty()) {
			request.setAttribute("allTeams", " ");
		}
		//test
		for(Team t: th.showAllTeams()) {
			System.out.println(t.toString());
		}
			getServletContext().getRequestDispatcher("/viewAllTeams.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
