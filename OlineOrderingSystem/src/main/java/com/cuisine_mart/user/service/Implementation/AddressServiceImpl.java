package com.cuisine_mart.user.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisine_mart.user.dao.IDaoContract.IAddressDAO;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.service.IServiceContract.IAddressService;
/**
 * @author Sadiksha
 *
 */
@Service
public class AddressServiceImpl implements IAddressService{
	@Autowired
	IAddressDAO addressDao;

	@Override
	public void saveAddress(Address address) {
		addressDao.save(address);
		
	}

	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return addressDao.findAll();
	}

	@Override
	public Address findAddressById(int addressId) {
		return addressDao.findAddressById(addressId);
	}

}
