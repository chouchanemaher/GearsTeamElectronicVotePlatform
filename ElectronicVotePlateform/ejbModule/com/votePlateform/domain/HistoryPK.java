package com.votePlateform.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class HistoryPK implements Serializable {
	
	private int IdAdmin;
	private int IdSession;
	
	
	

	public HistoryPK(int idAdmin, int idSession) {
		super();
		IdAdmin = idAdmin;
		IdSession = idSession;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdAdmin;
		result = prime * result + IdSession;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryPK other = (HistoryPK) obj;
		if (IdAdmin != other.IdAdmin)
			return false;
		if (IdSession != other.IdSession)
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HistoryPK() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSession() {
		return IdSession;
	}

	public void setIdSession(int idSession) {
		IdSession = idSession;
	}

	public int getIdAdmin() {
		return IdAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		IdAdmin = idAdmin;
	}

}
