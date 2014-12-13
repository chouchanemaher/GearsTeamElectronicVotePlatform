package com.votePlateform.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Session
 *
 */
@Entity

public class Session implements Serializable {

	   
	
	private int IdSession;
	private String DescriptionOfSession;
	private Date OpeningDateOfSession;
	private Date EndingDateOfSession;
	private List<Condidat>ListCondidat;
	
	private List<History>histoty;
	private static final long serialVersionUID = 1L;

	public Session() {
		
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getIdSession() {
		return this.IdSession;
	}

	public void setIdSession(int IdSession) {
		this.IdSession = IdSession;
	}   
	public String getDescriptionOfSession() {
		return this.DescriptionOfSession;
	}

	public void setDescriptionOfSession(String DescriptionOfSession) {
		this.DescriptionOfSession = DescriptionOfSession;
	}   
	public Date getOpeningDateOfSession() {
		return this.OpeningDateOfSession;
	}

	public void setOpeningDateOfSession(Date OpeningDateOfSession) {
		this.OpeningDateOfSession = OpeningDateOfSession;
	}   
	public Date getEndingDateOfSession() {
		return this.EndingDateOfSession;
	}

	public void setEndingDateOfSession(Date EndingDateOfSession) {
		this.EndingDateOfSession = EndingDateOfSession;
	}
	@OneToMany(mappedBy="session")
	public List<Condidat> getListCondidat() {
		return ListCondidat;
	}
	public void setListCondidat(List<Condidat> listCondidat) {
		ListCondidat = listCondidat;
	}
	@OneToMany(mappedBy="session",fetch=FetchType.EAGER)
	public List<History> getHistoty() {
		return histoty;
	}
	public void setHistoty(List<History> histoty) {
		this.histoty = histoty;
	}
   
}
