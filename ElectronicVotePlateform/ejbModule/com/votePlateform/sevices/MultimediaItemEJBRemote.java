package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Remote;

import com.votePlateform.domain.MultimediaItem;

@Remote
public interface MultimediaItemEJBRemote {
	public void addMultimediaItem(MultimediaItem m);

	public void deleteMultimediaItem(MultimediaItem m);

	public void updateMultimediaItem(MultimediaItem m);

	public MultimediaItem findById(int id);

	public List<MultimediaItem> findAll();

	public List<MultimediaItem> findByParty(int id);
}
