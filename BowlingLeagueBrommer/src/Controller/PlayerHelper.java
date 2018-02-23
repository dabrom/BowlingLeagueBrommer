package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Player;

public class PlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueBrommer");
	
	public void insertItem(Player toAdd) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(toAdd);
	em.getTransaction().commit();
	em.close();
	}

}
