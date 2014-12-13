package com.votePlateform.domain;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import com.votePlateform.domain.Condidat;

/**
 * Entity implementation class for Entity: IndependetCondidate
 *
 */
@Entity(name = "IndependetCondidate")
public class Independent extends Condidat implements Serializable {

	private String PhoneNumber;
	private String ElectionType;
	private static final long serialVersionUID = 1L;

	public Independent() {
		super();
	}

	public String getPhoneNumber() {
		return this.PhoneNumber;
	}

	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}

	public String getElectionType() {
		return this.ElectionType;
	}

	public void setElectionType(String ElectionType) {
		this.ElectionType = ElectionType;
	}

}
