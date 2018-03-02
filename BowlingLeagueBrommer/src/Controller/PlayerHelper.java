package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Player;

public class PlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueBrommer");
	
	public void insertPlayer(Player toAdd) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(toAdd);
	em.getTransaction().commit();
	em.close();
	}
	
	public Player searchForPlayerById(int playerId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player foundItem = em.find(Player.class, playerId);
		em.close();
		return foundItem;
	}
	
	public List<Player> showAllPlayers() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select pl from Player pl", Player.class);
		List<Player> allPlayers = allResults.getResultList();
		em.close();
		return allPlayers;
	}
	public void deletePlayer(Player toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player toRemove = em.find(Player.class, toDelete.getPlayerId());
		em.remove(toRemove);
		em.getTransaction().commit();
		em.close();
	}

}
