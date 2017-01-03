package com.cuisine_mart.user.service.IServiceContract;

import com.cuisine_mart.user.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Sadiksha
 *
 */
@Service
public interface IPersonService {
	public Person create(Person person);
	public Person update(Person person);
	public void delete(Long personId);
	public Person findPersonById(Long personId);
	public Person findPersonByEmail(String email);
	public List<Person> getReportForPersonByLocations();
}
