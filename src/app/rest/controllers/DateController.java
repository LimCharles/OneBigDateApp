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

import app.components.DateComponent;
import app.entity.Date;
import app.entity.DateLocation;

@Component
@Path("/dates")
public class DateController {
	
	Logger logger = LoggerFactory.getLogger(DateController.class);

	
	@Autowired
	DateComponent dateComponent;
	
	@POST
	@Path("/planStudentDate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String planStudentDate(
			@FormParam("locationName") String locationName,
			@FormParam("activityName") String activityName,
			@FormParam("studentAId") int studentAId,
			@FormParam("studentBId") int studentBId,
			@FormParam("duration") int duration,
			@FormParam("plannedDay") String plannedDay) throws Exception
	{
		return dateComponent.registerStudentDate(locationName, activityName, studentAId, studentBId, duration, plannedDay);
	}
	
	@POST
	@Path("/planProfessorDate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String planProfessorDate(
			@FormParam("locationName") String locationName,
			@FormParam("activityName") String activityName,
			@FormParam("professorAId") int professorAId,
			@FormParam("professorBId") int professorBId,
			@FormParam("duration") int duration,
			@FormParam("plannedDay") String plannedDay) throws Exception
	{
		return dateComponent.registerProfessorDate(locationName, activityName, professorAId, professorBId, duration, plannedDay);
	}
	
	@GET
	@Path("/dateDayList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Date> getDateListFromPlannedDay(
			@QueryParam("plannedDay") String plannedDay)
	{
		return dateComponent.getDateListFromPlannedDay(plannedDay);			
	}
}
