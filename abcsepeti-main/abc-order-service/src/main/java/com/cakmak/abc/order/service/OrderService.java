package com.cakmak.abc.order.service;

import com.cakmak.abc.order.web.CreateOrderRequest;
import com.cakmak.abc.order.web.CreateOrderResponse;
import com.cakmak.abc.order.web.PreviewOrderRequest;
import com.cakmak.abc.order.web.PreviewOrderResponse;

import java.util.List;

/**
 * @author: Halil Cakmak,
 * Date : 2019-09-20
 */
public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    PreviewOrderResponse previewOrder(PreviewOrderRequest previewOrderRequest);

    CreateOrderResponse getOrderById(String orderId);

    List<CreateOrderResponse> getMyOrders();

    List<CreateOrderResponse> getAllOrders();
}
