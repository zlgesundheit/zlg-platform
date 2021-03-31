package com.schneider.restendpoint.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

// https://howtodoinjava.com/jersey/jersey-file-upload-example/
/*
 * Eigentlich nicht Part des Metadata-Packages, sondern com.schneider.restendpoint -> siehe EHRBaseConnectorFileEndpoint.java
 */

@Path("/upload/csv")
public class CsvUploadHandler {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMsg() {
		return "REST-Endpunkt CsvUploadHandler";
	}
	
	@POST
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadCsvFile(  @FormDataParam("file") InputStream fileInputStream,
	                                @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception
	{	
		//Upload Path needs to be set in Tomcat.Properties (for now i am using the Eclipse Embedded Tomcat with the workdir on my desktop)
		String UPLOAD_PATH = "./uploaded_files/";
		//Unique but recognizable file names so users cant overwrite files of others? --> Some considerations to take into account...
		String filePath = new File("test.csv").getAbsolutePath();
		//OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
		
		return (Response.ok("Ok: " + filePath + " --> Upload-Filename" + fileMetaData.getFileName()).build());
		
		/*
		String UPLOAD_PATH = "c:/temp/";
	    try
	    {
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
	        while ((read = fileInputStream.read(bytes)) != -1) 
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e) 
	    {
	        throw new WebApplicationException("Error while uploading file. Please try again !!");
	    }
	    return Response.ok("Data uploaded successfully !! Filename:" + fileMetaData.getFileName()).build();
	    */
	}
	
}
