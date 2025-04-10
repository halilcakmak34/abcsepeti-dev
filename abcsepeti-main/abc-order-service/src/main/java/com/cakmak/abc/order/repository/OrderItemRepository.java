package com.cakmak.abc.order.repository;

import com.cakmak.abc.order.repository.dao.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Halil Cakmak,
 * Date : 2019-09-18
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
}
