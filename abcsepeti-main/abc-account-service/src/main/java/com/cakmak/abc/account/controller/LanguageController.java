package com.cakmak.abc.account.controller;

import com.cakmak.abc.account.model.dto.ResultService;
import com.cakmak.abc.account.model.request.LanguageRequest;
import com.cakmak.abc.account.model.response.LanguageResponse;
import com.cakmak.abc.account.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LanguageController {

    @Autowired
    private LanguageService languageService;
    @PostMapping("/language/action")
    @PreAuthorize("hasAuthority('STANDARD_USER')")
    @ResponseBody
    public ResponseEntity<ResultService<LanguageResponse>> actionLanguage(@RequestBody LanguageRequest request){
        return new ResponseEntity<>(languageService.action(request), HttpStatus.OK);
    }

}
