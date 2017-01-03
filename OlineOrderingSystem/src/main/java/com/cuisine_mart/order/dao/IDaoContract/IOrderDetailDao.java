package com.cuisine_mart.order.dao.IDaoContract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.order.domain.OrderDetail;

@Repository
public interface IOrderDetailDao extends JpaRepository<OrderDetail, Long> {

}
