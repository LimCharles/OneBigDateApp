package app.components;

import javax.annotation.PostConstruct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.DateLocation;
import app.repositories.DateLocationRepository;

@Component
public class DateLocationComponent {

	@Autowired
	private DateLocationRepository dateLocationRepository;
	
	public Long register(String name, double latitude, double longitude) {
		DateLocation newDateLocation = new DateLocation();
		
		newDateLocation.setName(name);
		newDateLocation.setLatitude(latitude);
		newDateLocation.setLongitude(longitude);
		
		newDateLocation = dateLocationRepository.save(newDateLocation);
		return newDateLocation.getId();
	}
	
	public List<DateLocation> getDateLocations() {
		return dateLocationRepository.findAll();
	}
}
