package com.cakmak.abc.payment.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Halil Cakmak - 17-Dec-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

    private int amount;
    @NotBlank
    private String currency;
    @NotBlank
    private String paymentMethodId;

}
