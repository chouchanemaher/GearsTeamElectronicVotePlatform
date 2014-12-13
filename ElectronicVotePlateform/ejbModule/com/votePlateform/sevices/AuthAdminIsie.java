package com.votePlateform.sevices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.votePlateform.domain.IsieAdmin;
import com.votePlateform.domain.MultimediaItem;
import com.votePlateform.domain.Session;

/**
 * Session Bean implementation class AuthAdminIsie
 */
@Stateless
public class AuthAdminIsie implements AuthAdminIsieRemote {

	@PersistenceContext(unitName = "ElectronicVotePlateform")
	EntityManager em;

	public IsieAdmin authentication(String login, String password) {
		Query query;
		query = (Query) em
				.createQuery(
						"select v from IsieAdmin v where v.LoginAdmin= :login and v.PasswordAdmin= :password")
				.setParameter("login", login)
				.setParameter("password", password);
		if (query.getResultList().size() == 0)
			return null;
		else {
			IsieAdmin a = (IsieAdmin) query.getResultList().get(0);
			return a;
		}
	}

	public AuthAdminIsie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateAdmin(IsieAdmin i) {
		em.merge(i);
	}

	@Override
	public List<IsieAdmin> findAll() {
		return em.createQuery("SELECT m FROM IsieAdmin m", IsieAdmin.class)
				.getResultList();
	}

	@Override
	public IsieAdmin serachAdminById(int id) {
		return em.find(IsieAdmin.class, id);
	}

	@Override
	public void removeAdminIsie(IsieAdmin i) {
		em.remove(em.merge(i));		
	}

}
