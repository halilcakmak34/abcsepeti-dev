package com.cakmak.abc.account.model.request;

import com.cakmak.abc.account.model.enm.OperationType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageRequest implements Serializable {

    private String id;
    private String tableName;
    private String columnName;
    @NotNull(message = "Lang null olamaz")
    private String lang;
    @NotNull(message = "Key null olamaz")
    private String key;
    private String value;
    private String pageName;
    private String type;
    @NotNull(message = "OperationType null olamaz")
    private OperationType operationType;
}
