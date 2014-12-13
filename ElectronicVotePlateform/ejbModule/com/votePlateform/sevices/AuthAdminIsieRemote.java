package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Remote;

import com.votePlateform.domain.IsieAdmin;

@Remote
public interface AuthAdminIsieRemote {
	public IsieAdmin authentication(String login, String password);

	public void updateAdmin(IsieAdmin i);
	
	public List<IsieAdmin> findAll();
	
	public IsieAdmin serachAdminById(int id);
	
	public void removeAdminIsie(IsieAdmin i);
}
