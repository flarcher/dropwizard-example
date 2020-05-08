package flarcher.pairing.http.resource;

import flarcher.pairing.http.model.Tournament;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tournament")
public class TournamentResource {

	public TournamentResource(int defaultTableCount) {
		this.defaultTableCount = defaultTableCount;
	}

	private final int defaultTableCount;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Tournament getDefaultTournament() {
		Tournament t = new Tournament();
		t.setTableCount(defaultTableCount);
		return t;
	}

}
