package com.cakmak.abc.account.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Error {
    private String msg;
    private String detail;
    private Throwable throwable;
}
