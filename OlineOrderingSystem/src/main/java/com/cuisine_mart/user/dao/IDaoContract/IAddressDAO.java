package com.cuisine_mart.user.dao.IDaoContract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.User;
/**
 * @author Sadiksha
 *
 */
@Repository
public interface IAddressDAO extends JpaRepository<Address, Long>{
	@Query("SELECT distinct a From Address a WHERE a.addressId = :addressId")
	public Address findAddressById(@Param("addressId") int id);

}
