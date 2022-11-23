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

import app.components.DateActivityComponent;
import app.entity.DateActivity;

@Component
@Path("/dateActivities")
public class DateActivityController {
	
	
	Logger logger = LoggerFactory.getLogger(DateLocationController.class);

	
	@Autowired
	DateActivityComponent dateActivityComponent;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addDateActivity(
			@FormParam("locationName") String locationName,
			@FormParam("activityName") String activityName,
			@FormParam("duration") int duration,
			@FormParam("possibleDays") String possibleDays,
			@FormParam("keyword") String keyword,
			@FormParam("price") int price)
	{
		return dateActivityComponent.register(locationName, activityName, duration, possibleDays, keyword, price);
	}
	
	@Path("/location")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DateActivity> getDateActivtiesOfLocation(
			@QueryParam("locationName") String locationName) 
	{
		return dateActivityComponent.getDateActivitiesOfLocation(locationName);			
	}
	
	@Path("/location+possibledays")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DateActivity> getDateActivtiesOfLocationAndPossibleDays(
			@QueryParam("locationName") String locationName,
			@QueryParam("possibleDays") String possibleDays)
	{
		return dateActivityComponent.getDateActivitiesOfLocationAndPossibleDays(locationName, possibleDays);			
	}
	
	@Path("/location+keyword")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DateActivity> getDateActivtiesOfLocationAndKeyword(
			@QueryParam("locationName") String locationName,
			@QueryParam("keyword") String keyword)
	{
		return dateActivityComponent.getDateActivitiesOfLocationAndKeyword(locationName, keyword);			
	}
}
