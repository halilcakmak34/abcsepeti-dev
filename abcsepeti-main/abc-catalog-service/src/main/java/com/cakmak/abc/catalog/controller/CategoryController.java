package com.cakmak.abc.catalog.controller;

import com.cakmak.abc.catalog.service.CategoryService;
import com.cakmak.abc.catalog.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author: Fatma Çakmak,
 * Date : 2019-06-06
 */
@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> createCategory(@RequestBody @Valid CreateCategoryRequest createCategoryRequest){

        String category = categoryService.createCategory(createCategoryRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{categoryId}")
                .buildAndExpand(category).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("categoryId") String categoryId) {

        CategoryResponse categoryResponse = categoryService.getCategory(categoryId);

        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping("/category/getAll")
    public ResponseEntity<List<CategoriesNameResponse>> getCategory() {

        List<CategoriesNameResponse> categoryResponse = categoryService.getAll();

        return ResponseEntity.ok(categoryResponse);
    }





    @DeleteMapping("/category/{categoryId}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") String categoryId) {

        categoryService.deleteCategory(categoryId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/category")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> updateCategory(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest) {

        categoryService.updateCategory(updateCategoryRequest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "allCategory" ,produces = "application/json")
    public ResponseEntity<?>  getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }


    @GetMapping(value = "/categories", produces = "application/json")
    public ResponseEntity<?> getAllCategory(Pageable pageable,
                                            PagedResourcesAssembler<CategoryResponse> assembler) {

        Page<CategoryResponse> list = categoryService.getAllCategory(pageable);
    
        Link link = new Link(ServletUriComponentsBuilder.fromCurrentRequest().build()
                                                        .toUriString());

        PagedModel<EntityModel<CategoryResponse>> resource = assembler.toModel(list, link);
    
        CategoryPagedResponse categoryPagedResponse = new CategoryPagedResponse();
        categoryPagedResponse.setPage(list);

        if (resource.getLink("first").isPresent()) {
            categoryPagedResponse.get_links().put("first", resource.getLink("first").get().getHref());
        }

        if (resource.getLink("prev").isPresent()) {
            categoryPagedResponse.get_links().put("prev", resource.getLink("prev").get().getHref());
        }

        if (resource.getLink("self").isPresent()) {
            categoryPagedResponse.get_links().put("self", resource.getLink("self").get().getHref());
        }

        if (resource.getLink("next").isPresent()) {
            categoryPagedResponse.get_links().put("next", resource.getLink("next").get().getHref());
        }

        if (resource.getLink("last").isPresent()) {
            categoryPagedResponse.get_links().put("last", resource.getLink("last").get().getHref());
        }
    
        return ResponseEntity.ok(categoryPagedResponse);

    }
}
