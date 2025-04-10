package com.cakmak.abc.payment.service;

import com.cakmak.abc.payment.web.CreatePaymentRequest;
import com.cakmak.abc.payment.web.CreatePaymentResponse;

/**
 * @author Halil Cakmak, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
