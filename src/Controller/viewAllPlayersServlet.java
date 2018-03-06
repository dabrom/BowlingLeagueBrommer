package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Player;

/**
 * Servlet implementation class viewAllPlayersServlet
 */
@WebServlet("/viewAllPlayersServlet")
public class viewAllPlayersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllPlayersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerHelper ph = new PlayerHelper();
		request.setAttribute("allPlayers", ph.showAllPlayers());
		if(ph.showAllPlayers().isEmpty()) {
			request.setAttribute("allPlayers", " ");
		}
		//test
		for(Player l: ph.showAllPlayers()) {
			System.out.println(l.toString());
		}
			getServletContext().getRequestDispatcher("/viewAllPlayers.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PlayerHelper ph = new PlayerHelper();
		String act = request.getParameter("doThisToItem");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
			}
		else if (act.equals("Delete Selected Player")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player playerToDelete = ph.searchForPlayerById(tempId);
			ph.deletePlayer(playerToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
			}
		else if (act.equals("Add New Player")) {
			getServletContext().getRequestDispatcher("/addPlayer.jsp").forward(request, response);
		}
	}

}
