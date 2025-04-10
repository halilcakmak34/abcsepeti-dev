package com.cakmak.abc.payment.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Halil Cakmak, Date : 25-Jul-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentMethodRequest {

    @NotNull
    private Card card;
}
