package com.votePlateform.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Candidate
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeCondidate")
@XmlRootElement
public class Condidat implements Serializable {

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = -3152961134022795387L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int IdCondidat;
	private String OccupationOfCondidate;
	private String LoginCondidate;
	private String PasswordCondidate;
	private String NameCondidate;
	private String SecondNameCondidate;
	@OneToMany(mappedBy="condidate")
	private List<Citizen> ListeCitizen;
	@ManyToOne
	private Session session;

	public Condidat() {
		super();
	}
	
	public int getIdCondidat() {
		return this.IdCondidat;
	}

	public void setIdCondidat(int IdCondidat) {
		this.IdCondidat = IdCondidat;
	}   
	public String getOccupationOfCondidate() {
		return this.OccupationOfCondidate;
	}

	public void setOccupationOfCondidate(String OccupationOfCondidate) {
		this.OccupationOfCondidate = OccupationOfCondidate;
	}   
	public String getLoginCondidate() {
		return this.LoginCondidate;
	}

	public void setLoginCondidate(String LoginCondidate) {
		this.LoginCondidate = LoginCondidate;
	}   
	public String getPasswordCondidate() {
		return this.PasswordCondidate;
	}

	public void setPasswordCondidate(String PasswordCondidate) {
		this.PasswordCondidate = PasswordCondidate;
	}   
	public String getNameCondidate() {
		return this.NameCondidate;
	}

	public void setNameCondidate(String NameCondidate) {
		this.NameCondidate = NameCondidate;
	}   
	public String getSecondNameCondidate() {
		return this.SecondNameCondidate;
	}

	public void setSecondNameCondidate(String SecondNameCondidate) {
		this.SecondNameCondidate = SecondNameCondidate;
	}

	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	public List<Citizen> getListeCitizen() {
		return ListeCitizen;
	}
	public void setListeCitizen(List<Citizen> listeCitizen) {
		ListeCitizen = listeCitizen;
	}
   
}
