package com.cakmak.abc.account.model.dto;

import com.cakmak.abc.account.model.enm.OperationType;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageDto {
    private String id;
    private String tableName;
    private String columnName;
    private String lang;
    private String key;
    private String value;
    private String pageName;
    private String type;
}
