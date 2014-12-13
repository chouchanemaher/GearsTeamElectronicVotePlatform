package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.votePlateform.domain.Session;

/**
 * Session Bean implementation class ManageSessionEJB
 */
@Stateless
public class ManageSessionEJB implements ManageSessionEJBRemote {

	@PersistenceContext(unitName = "ElectronicVotePlateform")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManageSessionEJB() {
	}

	@Override
	public void addSession(Session session) {
		em.persist(session);
	}

	@Override
	public void updateSession(Session session) {
		em.merge(session);
	}

	@Override
	public void deleteSession(int id) {
		em.remove(em.merge(findById(id)));
	}

	@Override
	public Session findById(int id) {
		return em.find(Session.class, id);
	}

	@Override
	public List<Session> findAll() {
		return em.createQuery("SELECT s FROM Session s",Session.class)
				.getResultList();
	}

}
