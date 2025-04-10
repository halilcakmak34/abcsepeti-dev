package com.cakmak.abc.account.model.response;

import com.cakmak.abc.account.model.dto.LanguageDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageResponse implements Serializable {
    private String msg;
    private List<LanguageDto> languageDtoList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
