package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import com.votePlateform.domain.Citizen;
import com.votePlateform.domain.Party;

@Remote
@Path("/rest")
public interface PartyEJBRemote {

	public void deleteParty(int id);
	
	public Party findById(int id);

	public List<Party> findAll();

	@GET
	@Path("/listOfParty")
	@Produces("application/xml")
	@Wrapped(element = "partys")
	public List<Party> findAllLazy();

	public List<Party> searchByname(String name);
	
	@GET
	@Path("/search/{name}")
	@Produces("application/xml")
	@Wrapped(element = "partys")
	public List<Party> searchBynameLazy(@PathParam("name") String name);
	
	@GET
	@Path("/findById/{id}")
	@Produces("application/xml")
	@Wrapped(element = "citizens")
	public List<Citizen> findCitizenById(@PathParam("id")int id);
}
