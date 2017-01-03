package com.cuisine_mart.user.service.Implementation;

import com.cuisine_mart.user.dao.IDaoContract.IPersonDAO;
import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
/**
 * @author Sadiksha
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements IPersonService {

	@Autowired
	IPersonDAO personDAO;
	
	
	@Override
	public Person create(Person person) {
		
		return personDAO.save(person);
	}

	/* (non-Javadoc)
	 * @see com.cuisine_mart.user.service.IServiceContract.IPersonService#update(com.cuisine_mart.user.domain.Person)
	 */
	@Override
	public Person update(Person person) {
		
		return personDAO.save(person);
		
	}

	/* (non-Javadoc)
	 * @see com.cuisine_mart.user.service.IServiceContract.IPersonService#delete(int)
	 */
	@Override
	public void delete(Long personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findPersonById(Long personId) {
		 return personDAO.findPersonById(personId);
	}

	@Override
	public Person findPersonByEmail(String email) {
		return personDAO.findPersonByEmail(email);
	}

	@Override
	public List<Person> getReportForPersonByLocations() {
		return personDAO.generateReportForRegisteredPersonsByLocation();
	}


}
