package com.votePlateform.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MultimediaItem
 *
 */
@Entity
public class MultimediaItem implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int IdItem;
	private String TypeOfItem;
	private String DescriptionOfItem;
	@ManyToOne
	private Party partyItem;
	@ManyToOne
	@JoinColumn(name = "isieAdmin_fk")
	private IsieAdmin isieAdmin;
	private String path;
	private static final long serialVersionUID = 1L;

	public MultimediaItem() {
		
	}

	public int getIdItem() {
		return this.IdItem;
	}

	public void setIdItem(int IdItem) {
		this.IdItem = IdItem;
	}

	public String getTypeOfItem() {
		return this.TypeOfItem;
	}

	public void setTypeOfItem(String TypeOfItem) {
		this.TypeOfItem = TypeOfItem;
	}

	public String getDescriptionOfItem() {
		return this.DescriptionOfItem;
	}

	public void setDescriptionOfItem(String DescriptionOfItem) {
		this.DescriptionOfItem = DescriptionOfItem;
	}

	public Party getParty() {
		return partyItem;
	}

	public void setParty(Party partyItem) {
		this.partyItem = partyItem;
	}

	public IsieAdmin getIsieAdmin() {
		return isieAdmin;
	}

	public void setIsieAdmin(IsieAdmin isieAdmin) {
		this.isieAdmin = isieAdmin;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
