package com.cakmak.abc.order.repository;

import com.cakmak.abc.order.repository.dao.OrderShippingAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Halil Cakmak, Date : 07-Dec-2020
 */
public interface OrderShippingAddressRepository extends CrudRepository<OrderShippingAddress, String> {
    OrderShippingAddress findByOrderId(String orderId);
}
