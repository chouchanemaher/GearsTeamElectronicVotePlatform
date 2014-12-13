package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.votePlateform.domain.Citizen;
import com.votePlateform.domain.Party;

/**
 * Session Bean implementation class PartyEJB
 */
@Stateless
public class PartyEJB implements PartyEJBRemote {

	@PersistenceContext(unitName = "ElectronicVotePlateform")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public PartyEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteParty(int id) {
		em.remove(em.merge(findById(id)));
	}

	@Override
	public Party findById(int id) {
		return em.find(Party.class, id);
	}

	@Override
	public List<Party> findAll() {
		return em.createQuery("SELECT pp FROM Party pp", Party.class)
				.getResultList();
	}

	@Override
	public List<Party> searchByname(String name) {

		return em
				.createQuery(
						"SELECT ppp FROM Party ppp WHERE ppp.NameCondidate LIKE :name",
						Party.class).setParameter("name", "%" + name + "%")
				.getResultList();
	}

	@Override
	public List<Party> findAllLazy() {
		return em
				.createQuery(
						"SELECT new Party(p.PasswordParty,p.LoginParty,p.DescriptionOfParty,p.PoliticalAffiliation,p.FoundingMember,p.IdCondidat,p.NameCondidate) FROM Party p",
						Party.class).getResultList();
	}

	@Override
	public List<Party> searchBynameLazy(String name) {
		return em
				.createQuery(
						"SELECT new Party(p.PasswordParty,p.LoginParty,p.DescriptionOfParty,p.PoliticalAffiliation,p.FoundingMember,p.IdCondidat,p.NameCondidate) FROM Party p WHERE p.NameCondidate LIKE :name",
						Party.class).setParameter("name", "%" + name + "%")
				.getResultList();
	}

	@Override
	public List<Citizen> findCitizenById(int id) {

		Query q;
		q = em.createQuery(
				"SELECT new Citizen(c.CIN,c.FirstName,c.ScondName,c.Adresse,c.Email,c.Password) FROM Citizen c WHERE c.partyCitizen.IdCondidat= :id",
				Citizen.class).setParameter("id", id);

		if (q.getResultList().size() != 0) {
			return q.getResultList();
		} else {
			return null;
		}
	}

}
