package com.votePlateform.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: IsieAdmin
 *
 */
@Entity
public class IsieAdmin implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int IdAdmin;
	private String PasswordAdmin;
	private String LoginAdmin;
	private String AdminName;
	private String AdminSecondName;

	@OneToMany(mappedBy = "isieAdmin")
	private List<History> listHistory;
	@OneToMany(mappedBy = "isieAdmin")
	private List<MultimediaItem> multimediaItem;

	public List<MultimediaItem> getMultimediaItem() {
		return multimediaItem;
	}

	public void setMultimediaItem(List<MultimediaItem> multimediaItem) {
		this.multimediaItem = multimediaItem;
	}

	private static final long serialVersionUID = 1L;

	public IsieAdmin() {
		super();
	}

	public String getPasswordAdmin() {
		return this.PasswordAdmin;
	}

	public void setPasswordAdmin(String PasswordAdmin) {
		this.PasswordAdmin = PasswordAdmin;
	}

	public String getLoginAdmin() {
		return this.LoginAdmin;
	}

	public void setLoginAdmin(String LoginAdmin) {
		this.LoginAdmin = LoginAdmin;
	}

	public int getIdAdmin() {
		return this.IdAdmin;
	}

	public void setIdAdmin(int IdAdmin) {
		this.IdAdmin = IdAdmin;
	}

	public List<History> getListHistory() {
		return listHistory;
	}

	public void setListHistory(List<History> listHistory) {
		this.listHistory = listHistory;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminSecondName() {
		return AdminSecondName;
	}

	public void setAdminSecondName(String adminSecondName) {
		AdminSecondName = adminSecondName;
	}

}
