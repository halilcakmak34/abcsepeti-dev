package com.cakmak.abc.payment.controller;

import com.cakmak.abc.payment.service.PaymentsService;
import com.cakmak.abc.payment.web.CreatePaymentRequest;
import com.cakmak.abc.payment.web.CreatePaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Halil Cakmak, Date : 25-Jul-2020
 */
@RestController
@Slf4j
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping("/pay")
    public ResponseEntity<?> doPayment(@RequestBody @Valid CreatePaymentRequest createPaymentRequest) {
        CreatePaymentResponse paymentRequest = paymentsService.createPaymentRequest(createPaymentRequest);
        return new ResponseEntity<>(paymentRequest, HttpStatus.CREATED);
    }

}
