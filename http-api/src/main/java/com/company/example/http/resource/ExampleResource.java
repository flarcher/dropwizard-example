package com.company.example.http.resource;

import com.company.example.http.model.ExampleModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("example")
public class ExampleResource {

	public ExampleResource(int count) {
            this.defaultCount = count;
	}

	private final int defaultCount;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ExampleModel getDefaultTournament() {
		ExampleModel t = new ExampleModel();
		t.setCount(defaultCount);
		return t;
	}

}
