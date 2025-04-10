package com.cakmak.abc.account.model.dto;


import com.cakmak.abc.account.model.enm.StatusType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultService<T>{
    T response;
    StatusType statusType;
    List<Error> errorMsgList = new ArrayList<>();
    List<Success> successMsgList = new ArrayList<>();
}
