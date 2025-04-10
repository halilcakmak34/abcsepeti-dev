package com.cakmak.abc.account.service;


import com.cakmak.abc.account.model.dto.ResultService;
import com.cakmak.abc.account.model.request.LanguageRequest;
import com.cakmak.abc.account.model.response.LanguageResponse;

public interface LanguageService {

     ResultService<LanguageResponse> action(LanguageRequest request);

}
