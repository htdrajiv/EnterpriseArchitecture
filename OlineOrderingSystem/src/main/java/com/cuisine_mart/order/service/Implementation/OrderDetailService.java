package com.cuisine_mart.order.service.Implementation;



import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cuisine_mart.order.domain.OrderDetail;
import com.cuisine_mart.order.exception.OrderNotFound;
import com.cuisine_mart.order.service.IServiceContract.IOrderDetailService;

@Service
public class OrderDetailService implements IOrderDetailService {

	@Override
	public OrderDetail create(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long orderDetailId) throws OrderNotFound {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetail> findByDate(Date date) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> findByType(String type) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail findById(Long id) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> findOrderDetailByOrderId(Long orderId) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
