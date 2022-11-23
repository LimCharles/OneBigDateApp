package app.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.DateLocationComponent;
import app.entity.DateLocation;

@Component
@Path("/dateLocations")
public class DateLocationController {
	
	
	Logger logger = LoggerFactory.getLogger(DateLocationController.class);

	
	@Autowired
	DateLocationComponent dateLocationComponent;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Long addDateLocation(
			@FormParam("name") String name,
			@FormParam("latitude") double latitude,
			@FormParam("longitude") double longitude)
	{
		return dateLocationComponent.register(name, latitude, longitude);
	}
	
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DateLocation> getDateLocations() {
		return dateLocationComponent.getDateLocations();			
	}
}
