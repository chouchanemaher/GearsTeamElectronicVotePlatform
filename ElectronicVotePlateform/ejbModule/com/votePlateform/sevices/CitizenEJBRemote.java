package com.votePlateform.sevices;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.votePlateform.domain.Citizen;

@Remote
@Path("/auth")
public interface CitizenEJBRemote {

	public void AddCitizen(Citizen citizen);

	public void UpdateCitizen(Citizen citizen, int c);

	public void DeleteCitizen(int cin);

	public List<Citizen> SearchCitizen(int cin);

	public List<Citizen> DisplayAllCitizen();

	public List<Citizen> searchByName(String name);

	@GET
	@Path("/login/{login}/{password}")
	@Produces("application/json")
	public Citizen login(@PathParam("login") String login,
			@PathParam("password") String password);

	@GET
	@Path("/vote/{idCitizen}/{idCandidate}")
	@Produces("text/plain")
	public String Vote(@PathParam("idCitizen") int idCItizen,
			@PathParam("idCandidate") int idCandidate);
}
