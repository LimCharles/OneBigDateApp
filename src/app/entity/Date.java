package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Date {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@NotNull(message="Date Location cannot be null")
	@Column
	private Long dateLocationId;
	
	@NotNull(message="Date Activity cannot be null")
	@Column
	private Long dateActivityId;
	
	@NotNull(message="Demographic cannot be null")
	@Pattern(regexp="students|professors")
	@Column
	private String demographic;
	
	@NotNull(message="Person A cannot be null")
	@Column
	private Long personAId;

	@NotNull(message="Person B cannot be null")
	@Column
	private Long personBId;

	@NotNull(message="Duration cannot be not null")
	@Range(min=10, max=360)
	@Column
	private int duration;

	@NotNull(message="Planned day cannot be null")
	@Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")
	@Column
	private String plannedDay;
	
	@Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")
	@Column
	private String actualDay;

	@Range(min=0, max=10)
	@Column
	private int rating;
	
	@Column
	private Boolean success;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDateLocationId() {
		return dateLocationId;
	}

	public void setDateLocationId(Long dateLocationId) {
		this.dateLocationId = dateLocationId;
	}

	public Long getDateActivityId() {
		return dateActivityId;
	}

	public void setDateActivityId(Long dateActivityId) {
		this.dateActivityId = dateActivityId;
	}

	public String getDemographic() {
		return demographic;
	}

	public void setDemographic(String demographic) {
		this.demographic = demographic;
	}

	public Long getPersonAId() {
		return personAId;
	}

	public void setPersonAId(Long personAId) {
		this.personAId = personAId;
	}

	public Long getPersonBId() {
		return personBId;
	}

	public void setPersonBId(Long personBId) {
		this.personBId = personBId;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPlannedDay() {
		return plannedDay;
	}

	public void setPlannedDay(String plannedDay) {
		this.plannedDay = plannedDay;
	}

	public String getActualDay() {
		return actualDay;
	}

	public void setActualDay(String actualDay) {
		this.actualDay = actualDay;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
