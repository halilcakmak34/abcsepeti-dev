package com.cakmak.abc.order.repository;

import com.cakmak.abc.order.repository.dao.Cart;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Halil Cakmak,
 * Date : 2019-07-08
 */
@Transactional
public interface CartRepository extends CrudRepository<Cart, String> {

    Cart findCartByUserName(String userName);

    Optional<Cart> findByCartId(String cartId);
}
