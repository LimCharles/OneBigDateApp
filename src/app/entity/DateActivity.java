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
public class DateActivity  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@NotNull(message="Name cannot be null")
	@Column
	private String name;
	
	@NotNull(message="Date Location cannot be null")
	@Column
	private Long dateLocationId;
	
	@NotNull(message="Duration cannot be not null")
	@Range(min=10, max=360)
	@Column
	private int duration;

	@NotNull(message="Possible Days cannot be null")
	@Pattern(regexp="Weekdays|Weekends|Everyday")
	@Column
	private String possibleDays;
	
	@NotNull(message="Keyword cannot be null")
	@Column
	private String keyword;

	@NotNull(message="Price cannot be null")
	@Column
	private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getDateLocationId() {
		return dateLocationId;
	}

	public void setDateLocationId(Long dateLocationId) {
		this.dateLocationId = dateLocationId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPossibleDays() {
		return possibleDays;
	}

	public void setPossibleDays(String possibleDays) {
		this.possibleDays = possibleDays;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
