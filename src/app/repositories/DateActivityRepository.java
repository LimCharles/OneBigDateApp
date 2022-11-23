package app.repositories;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.DateActivity;

@Repository
public interface DateActivityRepository extends JpaRepository<DateActivity, Long> {
	public DateActivity findByName(String name);
	public DateActivity findByDateLocationIdAndName(Long dateLocationId, String name);
	public List<DateActivity> findByDateLocationId(Long dateLocationId);
	public List<DateActivity> findByDateLocationIdAndPossibleDays(Long dateLocationId, String possibleDays);
	public List<DateActivity> findByDateLocationIdAndKeyword(Long dateLocationId, String keyword);
	public List<DateActivity> findByKeyword(String keyword);
	public List<DateActivity> findByPriceLessThan(double price);
	public List<DateActivity> findByPriceGreaterThan(double price);
	public List<DateActivity> findByDateLocationIdAndPriceLessThan(Long dateLocationId, double price);
	public List<DateActivity> findByDateLocationIdAndPriceGreaterThan(Long dateLocationId, double price);
}
