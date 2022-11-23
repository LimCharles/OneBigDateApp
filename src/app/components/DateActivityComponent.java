package app.components;

import javax.annotation.PostConstruct;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.DateActivity;
import app.repositories.DateActivityRepository;
import app.entity.DateLocation;
import app.repositories.DateLocationRepository;

@Component
public class DateActivityComponent {

	@Autowired
	private DateActivityRepository dateActivityRepo;
	
	@Autowired
	private DateLocationRepository dateLocationRepo;
	
	public String register(String locationName, String activityName, int duration, String possibleDays, String keyword, double price) {
		DateLocation oldDateLocation = dateLocationRepo.findByName(locationName);
		if (oldDateLocation == null) {
			return "Location not found in database.";
		} 
				
		DateActivity newDateActivity = new DateActivity();
		
		newDateActivity.setName(activityName);
		newDateActivity.setDateLocationId(oldDateLocation.getId());
		newDateActivity.setDuration(duration);
		newDateActivity.setPossibleDays(possibleDays);
		newDateActivity.setKeyword(keyword);
		newDateActivity.setPrice(price);
		
		newDateActivity = dateActivityRepo.save(newDateActivity);
		return "Registered new date activity with id: " + String.valueOf(newDateActivity.getId());
	}
	
	public List<DateActivity> getDateActivitiesOfLocation(String locationName) {
		DateLocation oldDateLocation = dateLocationRepo.findByName(locationName);
		if (oldDateLocation == null) {
			return Collections.emptyList();
		} 
		
		return dateActivityRepo.findByDateLocationId(oldDateLocation.getId());
	}
	
	public List<DateActivity> getDateActivitiesOfLocationAndPossibleDays(String locationName, String possibleDays) {
		DateLocation oldDateLocation = dateLocationRepo.findByName(locationName);
		if (oldDateLocation == null) {
			return Collections.emptyList();
		} 
		
		return dateActivityRepo.findByDateLocationIdAndPossibleDays(oldDateLocation.getId(), possibleDays);
	}
	
	public List<DateActivity> getDateActivitiesOfLocationAndKeyword(String locationName, String keyword) {
		DateLocation oldDateLocation = dateLocationRepo.findByName(locationName);
		if (oldDateLocation == null) {
			return Collections.emptyList();
		} 
		
		return dateActivityRepo.findByDateLocationIdAndKeyword(oldDateLocation.getId(), keyword);
	}
}
