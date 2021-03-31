package com.schneider.restendpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Java Class that implements the REST endpoint functionalities handling
 * incoming files and data.
 */
@Path("/files")
public class EHRBaseConnectorFileEndpoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getMsg(String csv) {

		return csv.toString();
	}
}
