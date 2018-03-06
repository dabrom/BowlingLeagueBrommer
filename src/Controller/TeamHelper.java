package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import Model.Player;
import Model.Team;

public class TeamHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueBrommer");
	
	public void insertTeam(Team toAdd) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(toAdd);
	em.getTransaction().commit();
	em.close();
	}

	public Team searchForTeamById(int teamID) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team foundItem = em.find(Team.class, teamID);
		em.close();
		return foundItem;
	}
	
	public List<Team> showAllTeams() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Team> allResults = em.createQuery("select li from Team li", Team.class);
		List<Team> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	
	public void deleteTeam(Team toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team toRemove = em.find(Team.class, toDelete.getTeamId());
		em.remove(toRemove);
		em.getTransaction().commit();
		em.close();
	}
}

