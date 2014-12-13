package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Remote;

import com.votePlateform.domain.Session;

@Remote
public interface ManageSessionEJBRemote {
	public void addSession(Session session);

	public void updateSession(Session session);

	public void deleteSession(int id);

	public Session findById(int id);

	public List<Session> findAll();

}
