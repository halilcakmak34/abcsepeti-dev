package com.cakmak.abc.order.service;

import com.cakmak.abc.order.repository.dao.Cart;

/**
 * @author: Halil Cakmak,
 * Date : 2019-06-17
 */
public interface CartService {

    Cart getCart();
    
    Cart getCartByCartId(String cartId);

    String createCart();

    Cart getCartByUserName(String userName);

}
