package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.votePlateform.domain.MultimediaItem;

/**
 * Session Bean implementation class NewsEJB
 */
@Stateless
public class MultimediaItemEJB implements MultimediaItemEJBRemote {

	@PersistenceContext(unitName = "ElectronicVotePlateform")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public MultimediaItemEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMultimediaItem(MultimediaItem m) {
		em.persist(m);

	}

	@Override
	public void deleteMultimediaItem(MultimediaItem m) {
		em.remove(em.merge(m));

	}

	@Override
	public void updateMultimediaItem(MultimediaItem m) {
		em.merge(m);

	}

	@Override
	public MultimediaItem findById(int id) {

		return em.find(MultimediaItem.class, id);
	}

	@Override
	public List<MultimediaItem> findAll() {
		return em.createQuery("SELECT m FROM MultimediaItem m",
				MultimediaItem.class).getResultList();
	}

	@Override
	public List<MultimediaItem> findByParty(int id) {
		return em
				.createQuery(
						"SELECT m FROM MultimediaItem m WHERE m.partyItem.IdCondidat= :id",
						MultimediaItem.class).setParameter("id", id)
				.getResultList();

	}

}
