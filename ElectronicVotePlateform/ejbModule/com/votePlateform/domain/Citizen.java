package com.votePlateform.domain;

import java.io.Serializable;
import java.lang.String;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Citizen
 *
 */
@Entity
@XmlRootElement
public class Citizen implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int CIN;
	private String FirstName;
	private String ScondName;
	private String Adresse;
	private String Email;
	private String Password;
	@ManyToOne
	private Condidat condidate;
	@ManyToOne
	private Party partyCitizen;

	public Citizen() {
		super();
	}

	public Citizen(int cIN, String firstName, String scondName, String adresse,
			String email, String password) {
		super();
		CIN = cIN;
		FirstName = firstName;
		ScondName = scondName;
		Adresse = adresse;
		Email = email;
		Password = password;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getScondName() {
		return this.ScondName;
	}

	public void setScondName(String ScondName) {
		this.ScondName = ScondName;
	}

	public int getCIN() {
		return this.CIN;
	}

	public void setCIN(int CIN) {
		this.CIN = CIN;
	}

	public String getAdresse() {
		return this.Adresse;
	}

	public void setAdresse(String Adresse) {
		this.Adresse = Adresse;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public Condidat getCondidate() {
		return condidate;
	}

	public void setCondidate(Condidat condidate) {
		this.condidate = condidate;
	}

	public Party getParty() {
		return partyCitizen;
	}

	public void setParty(Party partyCitizen) {
		this.partyCitizen = partyCitizen;
	}

}
