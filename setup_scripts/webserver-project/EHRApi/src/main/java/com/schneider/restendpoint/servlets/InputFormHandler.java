package com.schneider.restendpoint.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/meta/form-param")
public class InputFormHandler {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMsg() {
		return "REST-Endpunkt InputFormHandler";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createCustomer(@FormParam("name") String name,
	                             @FormParam("phone-number") String phoneNumber,
	                             @FormParam("checkbox") String checkbox) {
			//System.out.print("Eingabe " + name + address + phoneNumber);
	        return ("" + name + checkbox + phoneNumber);
	    }
}