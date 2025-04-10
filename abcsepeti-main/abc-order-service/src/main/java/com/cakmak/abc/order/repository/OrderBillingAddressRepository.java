package com.cakmak.abc.order.repository;

import com.cakmak.abc.order.repository.dao.OrderBillingAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Halil Cakmak, Date : 07-Dec-2020
 */
public interface OrderBillingAddressRepository extends CrudRepository<OrderBillingAddress, String> {
    OrderBillingAddress findByOrderId(String orderId);
}
