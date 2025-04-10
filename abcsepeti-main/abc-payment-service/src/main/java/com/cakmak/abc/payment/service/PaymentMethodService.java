package com.cakmak.abc.payment.service;

import com.cakmak.abc.payment.web.CreatePaymentMethodRequest;
import com.cakmak.abc.payment.web.GetPaymentMethodResponse;

import java.util.List;

/**
 * @author Halil Cakmak, Date : 25-Jul-2020
 */
public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
