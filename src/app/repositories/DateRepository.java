package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Date;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
	public List<Date> findByPlannedDay(String plannedDay);
	public List<Date> findByPersonAIdAndDemographic(Long personAId, String demographic);
	public List<Date> findByPersonBIdAndDemographic(Long personBId, String demographic);
	public List<Date> findByPersonAIdAndPersonBIdAndDemographic(Long personAId, Long personBId, String demographic);
}
