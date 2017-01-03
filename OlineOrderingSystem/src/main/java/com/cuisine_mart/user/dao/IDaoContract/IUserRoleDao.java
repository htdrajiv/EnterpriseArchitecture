/**
 * 
 */
package com.cuisine_mart.user.dao.IDaoContract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cuisine_mart.user.domain.UserRole;

/**
 * @author Sadiksha
 *
 */
@Repository
public interface IUserRoleDao extends JpaRepository<UserRole, Long>  {

}
