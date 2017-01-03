package com.cuisine_mart.user.dao.IDaoContract;

import java.util.List;

import com.cuisine_mart.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.user.domain.Person;
/**
 * @author Sadiksha
 *
 */
@Repository
public interface IPersonDAO extends JpaRepository<Person, Long>{
	@Query("SELECT distinct p FROM Person p Where p.personId=:id ")
	public Person findPersonById(@Param ("id")Long personId);
	
	@Query("SELECT distinct p FROM Person p WHERE p.email=:email")
	public Person findPersonByEmail(@Param("email")String email);

	@Query("select a.city, count(p) from Person p join p.address a group by a.city")
	public List<Person> generateReportForRegisteredPersonsByLocation();
}
