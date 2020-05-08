package com.company.example.http.resource;

import com.company.example.http.model.ExampleModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tournament")
public class ExampleResource {

	public ExampleResource(int defaultTableCount) {
		this.defaultTableCount = defaultTableCount;
	}

	private final int defaultTableCount;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ExampleModel getDefaultTournament() {
		ExampleModel t = new ExampleModel();
		t.setCount(defaultTableCount);
		return t;
	}

}
