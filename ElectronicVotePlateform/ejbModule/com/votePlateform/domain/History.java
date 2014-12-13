package com.votePlateform.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: History
 *
 */
@Entity

public class History implements Serializable {

	   
	
	private int IdHistory;
	private HistoryPK historyPK;
	private Session session;
	private IsieAdmin isieAdmin;
	
	private static final long serialVersionUID = 1L;

	public History() {
		super();
	}   
	
	public int getId() {
		return this.IdHistory;
	}

	public void setId(int Id) {
		this.IdHistory = Id;
	}
	@ManyToOne
	@JoinColumn(name="IdSession",insertable=false,updatable=false)
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	@ManyToOne
	@JoinColumn(name="IdAdmin",insertable=false,updatable=false)
	public IsieAdmin getIsieAdmin() {
		return isieAdmin;
	}
	public void setIsieAdmin(IsieAdmin isieAdmin) {
		this.isieAdmin = isieAdmin;
	}
	@EmbeddedId
	public HistoryPK getHistoryPK() {
		return historyPK;
	}
	public void setHistoryPK(HistoryPK historyPK) {
		this.historyPK = historyPK;
	}
   
}
