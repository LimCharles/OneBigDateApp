package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.DateLocation;

@Repository
public interface DateLocationRepository extends JpaRepository<DateLocation, Long> {
	public DateLocation findByName(String name);
}
