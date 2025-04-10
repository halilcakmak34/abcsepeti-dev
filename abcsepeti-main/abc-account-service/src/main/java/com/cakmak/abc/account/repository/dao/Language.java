package com.cakmak.abc.account.repository.dao;

import com.cakmak.abc.commons.util.DateAudit;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LANGUAGE")
@Builder
public class Language extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;
    @Column(name = "TABLE_NAME", nullable = true)
    private String tableName;
    @Column(name = "COLUMN_NAME", nullable = true)
    private String columnName;


    @Column(name = "LANG", nullable = false)
    private String lang;

    @Column(name = "KEY", nullable = false)
    private String key;

    @Column(name = "VALUE", nullable = false)
    private String value;
    @Column(name = "PAGE_NAME", nullable = true)
    private String pageName;

    @Column(name = "TYPE", nullable = true)
    private String type;

}
