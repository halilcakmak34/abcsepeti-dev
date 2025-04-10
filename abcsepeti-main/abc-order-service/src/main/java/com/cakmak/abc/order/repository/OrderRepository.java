package com.cakmak.abc.order.repository;

import com.cakmak.abc.order.repository.dao.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: Halil Cakmak,
 * Date : 2019-09-18
 */
public interface OrderRepository extends CrudRepository<Order, String> {

    Order findByOrderId(String orderId);

    List<Order> findByUserId(String userId);
}
