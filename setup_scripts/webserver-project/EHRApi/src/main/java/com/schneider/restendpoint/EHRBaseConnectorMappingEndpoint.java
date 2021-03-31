package com.schneider.restendpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Java Class that implements the REST endpoint functionalities handling incoming
 * mapping files.
 */
@Path("/mapping")
public class EHRBaseConnectorMappingEndpoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMapping() {
		return null;
	}
}
