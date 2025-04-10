package com.cakmak.abc.order.service;

import com.cakmak.abc.order.repository.dao.CartItem;
import com.cakmak.abc.order.web.CartItemRequest;

/**
 * @author: Halil Cakmak,
 * Date : 2019-06-17
 */
public interface CartItemService {

    void addCartItem(CartItemRequest cartItemRequest);
    void removeCartItem(String cartItemId);
    CartItem getCartItem(String cartItemId);
    void removeAllCartItems(String cartId);

}
