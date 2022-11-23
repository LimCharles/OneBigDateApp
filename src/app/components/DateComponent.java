package app.components;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import okhttp3.ResponseBody;
import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import app.entity.*;
import app.repositories.*;

@Component
public class DateComponent {

	Retrofit retrofit;
	
	@PostConstruct
	public void init() {
		retrofit =  new Retrofit.Builder()
					.baseUrl("https://bogus")
					.addConverterFactory(GsonConverterFactory.create())
					.build();
	}
	
	@Autowired
	private DateRepository dateRepo;
	
	@Autowired
	private DateLocationRepository dateLocationRepo;
	
	@Autowired
	private DateActivityRepository dateActivityRepo;
	
	public String registerStudentDate(String locationName, String activityName, int studentAId, int studentBId, int duration, String plannedDay) throws Exception {
		DateLocation oldDateLocation = dateLocationRepo.findByName(locationName);
		if (oldDateLocation == null) {
			return "Location not found in database.";
		} 
		DateActivity oldDateActivity = dateActivityRepo.findByName(activityName);
		if (oldDateActivity == null) {
			return "Activity not found in database.";
		}
		oldDateActivity = dateActivityRepo.findByDateLocationIdAndName(oldDateLocation.getId(), activityName);
		if (oldDateActivity == null) {
			return "Activity not possible in location.";
		}
		
		RemoteAteneoCommunity service = retrofit.create(RemoteAteneoCommunity.class);
		
		Call<StudentDto> studentAService = service.student(studentAId);
		Response<StudentDto> studentAReply = studentAService.execute();
		StudentDto studentA = studentAReply.body();
		if (studentA == null) {
			return "Student A not found in server";
		}
	
		Call<StudentDto> studentBService = service.student(studentBId);
		Response<StudentDto> studentBReply = studentBService.execute();
		StudentDto studentB = studentBReply.body();
		if (studentB == null) {
			return "Student B not found in server";
		}
		
		// To Add: More rules about which parties can date based on gender, sexual orientation
		
		Date newDate = new Date();
		newDate.setDateLocationId(oldDateLocation.getId());
		newDate.setDateActivityId(oldDateActivity.getId());
		newDate.setDemographic("students");
		newDate.setPersonAId(studentA.getId());
		newDate.setPersonBId(studentB.getId());
		newDate.setDuration(duration);
		newDate.setPlannedDay(plannedDay);
		
		newDate = dateRepo.save(newDate);
		return "Date planned successfully with id: " + String.valueOf(newDate.getId());
	}
	
	public String registerProfessorDate(String locationName, String activityName, int professorAId, int professorBId, int duration, String plannedDay) throws Exception {
		DateLocation oldDateLocation = dateLocationRepo.findByName(locationName);
		if (oldDateLocation == null) {
			return "Location not found in database.";
		} 
		DateActivity oldDateActivity = dateActivityRepo.findByName(activityName);
		if (oldDateActivity == null) {
			return "Activity not found in database.";
		}
		oldDateActivity = dateActivityRepo.findByDateLocationIdAndName(oldDateLocation.getId(), activityName);
		if (oldDateActivity == null) {
			return "Activity not possible in location.";
		}
		
		RemoteAteneoCommunity service = retrofit.create(RemoteAteneoCommunity.class);
		
		Call<ProfessorDto> professorAService = service.professor(professorAId);
		Response<ProfessorDto> professorAReply = professorAService.execute();
		ProfessorDto professorA = professorAReply.body();
		if (professorA == null) {
			return "Professor A not found in server";
		}
	
		Call<ProfessorDto> professorBService = service.professor(professorBId);
		Response<ProfessorDto> professorBReply = professorBService.execute();
		ProfessorDto professorB = professorBReply.body();
		if (professorB == null) {
			return "Professor B not found in server";
		}
		
		if (professorA.getDepartment().equals(professorB.getDepartment())) {
			return "Professors from same department cannot date";
		}
		
		// To Add: More rules about which parties can date based on gender, sexual orientation
		
		Date newDate = new Date();
		newDate.setDateLocationId(oldDateLocation.getId());
		newDate.setDateActivityId(oldDateActivity.getId());
		newDate.setDemographic("professors");
		newDate.setPersonAId(professorA.getId());
		newDate.setPersonBId(professorB.getId());
		newDate.setDuration(duration);
		newDate.setPlannedDay(plannedDay);
		
		newDate = dateRepo.save(newDate);
		return "Date planned successfully with id: " + String.valueOf(newDate.getId());
	}
	
	public List<Date> getDateListFromPlannedDay(String plannedDay) {
		return dateRepo.findByPlannedDay(plannedDay);
	}
}
