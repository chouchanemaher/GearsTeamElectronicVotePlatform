package com.votePlateform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Party
 *
 */
@Entity
@XmlRootElement(name="party")
public class Party extends Condidat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2512562225677125553L;
	private String PasswordParty;
	private String LoginParty;
	private String DescriptionOfParty;
	private String PoliticalAffiliation;
	
	@OneToMany(mappedBy = "partyItem",fetch=FetchType.LAZY)
	private List<MultimediaItem> ListOfItems= new ArrayList<MultimediaItem>();
	@OneToMany(mappedBy = "partyCitizen", fetch = FetchType.LAZY)
	private List<Citizen> ListOfCitizen;
	private String FoundingMember;


	public Party() {
		super();
	}

	
	public Party(String passwordParty, String loginParty,
			String descriptionOfParty, String politicalAffiliation,
			String foundingMember,int idCondidat,String nameCandidate) {
		super();
		PasswordParty = passwordParty;
		LoginParty = loginParty;
		DescriptionOfParty = descriptionOfParty;
		PoliticalAffiliation = politicalAffiliation;
		FoundingMember = foundingMember;
		super.setIdCondidat(idCondidat);
		super.setNameCondidate(nameCandidate);
	}


	public String getFoundingMember() {
		return this.FoundingMember;
	}

	public void setFoundingMember(String FoundingMember) {
		this.FoundingMember = FoundingMember;
	}

	public String getPasswordParty() {
		return this.PasswordParty;
	}

	public void setPasswordParty(String PasswordParty) {
		this.PasswordParty = PasswordParty;
	}

	public String getLoginParty() {
		return this.LoginParty;
	}

	public void setLoginParty(String LoginParty) {
		this.LoginParty = LoginParty;
	}

	public String getDescriptionOfParty() {
		return this.DescriptionOfParty;
	}

	public void setDescriptionOfParty(String DescriptionOfParty) {
		this.DescriptionOfParty = DescriptionOfParty;
	}

	public String getPoliticalAffiliation() {
		return this.PoliticalAffiliation;
	}

	public void setPoliticalAffiliation(String PoliticalAffiliation) {
		this.PoliticalAffiliation = PoliticalAffiliation;
	}

	public List<MultimediaItem> getListOfItems() {
		return ListOfItems;
	}

	public void setListOfItems(List<MultimediaItem> listOfItems) {
		ListOfItems = listOfItems;
	}

	public List<Citizen> getListOfCitizen() {
		return ListOfCitizen;
	}

	public void setListOfCitizen(List<Citizen> listOfCitizen) {
		ListOfCitizen = listOfCitizen;
	}

}
