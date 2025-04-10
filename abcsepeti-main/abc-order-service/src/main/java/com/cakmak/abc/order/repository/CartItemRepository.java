package com.cakmak.abc.order.repository;

import com.cakmak.abc.order.repository.dao.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Halil Cakmak,
 * Date : 2019-07-13
 */

public interface CartItemRepository extends CrudRepository<CartItem, String> {

    @Modifying
    @Transactional
    void deleteByCartItemId(String cartItemId);

    Optional<CartItem> findByCartItemId(String cartItemId);
}
