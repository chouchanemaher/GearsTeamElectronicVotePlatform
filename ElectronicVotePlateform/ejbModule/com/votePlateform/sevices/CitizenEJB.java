package com.votePlateform.sevices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.votePlateform.domain.Citizen;
import com.votePlateform.domain.Party;

/**
 * Session Bean implementation class CitizenEJB
 */
@Stateless
public class CitizenEJB implements CitizenEJBRemote {

	/**
	 * Default constructor.
	 */

	@PersistenceContext(name = "ElectronicVotePlateform")
	EntityManager em;

	public CitizenEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void AddCitizen(Citizen citizen) {

		em.persist(citizen);

	}

	@Override
	public void UpdateCitizen(Citizen citizen, int c) {

		Citizen cit = em.find(Citizen.class, c);
		cit.setFirstName(citizen.getFirstName());
		cit.setScondName(citizen.getScondName());
		cit.setCIN(citizen.getCIN());
		cit.setEmail(citizen.getEmail());
		cit.setAdresse(citizen.getAdresse());

		em.merge(cit);
	}

	@Override
	public List<Citizen> SearchCitizen(int cin) {
		// TODO Auto-generated method stub

		return em.createNativeQuery(
				"SELECT * FROM Citizen WHERE CIN like '" + cin + "%';",
				Citizen.class).getResultList();

	}

	@Override
	public void DeleteCitizen(int cin) {
		// TODO Auto-generated method stub

		em.remove(em.find(Citizen.class, cin));

	}

	@Override
	public List<Citizen> DisplayAllCitizen() {

		List<Citizen> listc = new ArrayList<Citizen>();
		javax.persistence.Query query = em
				.createQuery("select c from Citizen c");
		listc = query.getResultList();

		return listc;

	}

	@Override
	public List<Citizen> searchByName(String name) {
		return em
				.createQuery(
						"SELECT cc FROM Citizen cc WHERE cc.FirstName LIKE :name",
						Citizen.class).setParameter("name", "%" + name + "%")
				.getResultList();
	}

	@Override
	public Citizen login(String login, String password) {
		Query query;
		query = (Query) em
				.createQuery(
						"SELECT new Citizen(c.CIN,c.FirstName,c.ScondName,c.Adresse,c.Email,c.Password) FROM Citizen c WHERE c.Email= :login AND c.Password= :password",
						Citizen.class).setParameter("login", login)
				.setParameter("password", password);

		if (query.getResultList().size() == 0) {
			return null;
		} else {
			Citizen c = (Citizen) query.getSingleResult();
			return c;
		}
	}

	@Override
	public String Vote(int idCItizen, int idCandidate) {
		Party p = em.find(Party.class, idCandidate);
		Citizen c = em.find(Citizen.class, idCItizen);
		c.setCondidate(p);
		em.merge(c);
		
		return "Vote ok";
	}

}
