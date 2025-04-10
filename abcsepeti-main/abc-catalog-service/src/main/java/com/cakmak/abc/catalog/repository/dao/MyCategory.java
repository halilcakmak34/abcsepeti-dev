package com.cakmak.abc.catalog.repository.dao;

import com.cakmak.abc.catalog.web.CategoryResponse;
import com.cakmak.abc.commons.util.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Fatma Cakmak,
 * Date : 2019-06-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "CATEGORY")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyCategory extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", updatable = false, nullable = false)
    private String categoryId;
    @Column(name = "PARENT_IDS",  nullable = false)
    private String parentId;

    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    @ManyToOne
    @ToString.Exclude
    private MyCategory parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    @JsonIgnoreProperties("parentCategory")
    @ToString.Exclude
    private List<MyCategory> subCategories = new ArrayList<>();


    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;

    @Column(name = "DESCRIPTION")
    private String description;


    public static CategoryResponse fromEntity(MyCategory category) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(category, CategoryResponse.class);
    }




}
