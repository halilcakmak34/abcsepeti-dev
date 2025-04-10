package com.cakmak.abc.commons.feign;

import com.cakmak.abc.commons.web.CreatePaymentResponse;
import com.cakmak.abc.commons.web.CreatePaymentRequest;
import com.cakmak.abc.commons.web.GetPaymentMethodResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Halil Cakmak, Date : 15-Dec-2020
 */
@FeignClient("abc-payment-service")
public interface PaymentFeignClient {

    @GetMapping("/paymentMethod/{paymentMethodId}")
    GetPaymentMethodResponse getMyPaymentMethodById(@PathVariable("paymentMethodId") String paymentMethodId);

    @PostMapping("/pay")
    CreatePaymentResponse doPayment(CreatePaymentRequest createPaymentRequest);
}
