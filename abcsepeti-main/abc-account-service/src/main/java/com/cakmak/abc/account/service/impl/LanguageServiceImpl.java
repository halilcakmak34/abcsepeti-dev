package com.cakmak.abc.account.service.impl;

import com.cakmak.abc.account.model.dto.LanguageDto;
import com.cakmak.abc.account.model.dto.ResultService;
import com.cakmak.abc.account.model.dto.Success;
import com.cakmak.abc.account.model.dto.Error;
import com.cakmak.abc.account.model.enm.OperationType;
import com.cakmak.abc.account.model.request.LanguageRequest;
import com.cakmak.abc.account.model.response.LanguageResponse;
import com.cakmak.abc.account.repository.LanguageRepository;
import com.cakmak.abc.account.repository.dao.Language;
import com.cakmak.abc.account.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;
    @Override
    public ResultService<LanguageResponse> action(LanguageRequest request) {
        ResultService<LanguageResponse> resultService = new ResultService<>();
        if(OperationType.ADD.equals(request.getOperationType()) || OperationType.UPDATE.equals(request.getOperationType())) {
            Language language = new Language();
            language.setLang(request.getLang());
            language.setId(request.getId());
            language.setColumnName(request.getColumnName());
            language.setTableName(request.getTableName());
            language.setType(request.getType());
            language.setKey(request.getKey());
            language.setValue(request.getValue());
            language.setPageName(request.getPageName());
            if(OperationType.ADD.equals(request.getOperationType())) {
                language.setCreatedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC));
            }

            if(OperationType.UPDATE.equals(request.getOperationType())) {
                language.setUpdatedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC));
            }

            language = languageRepository.save(language);
            LanguageResponse languageResponse = new LanguageResponse();
            if (Objects.nonNull(language)) {
                Success success = Success.builder().msg("Language Başarılı Kaydedildi").build();
                resultService.getSuccessMsgList().add(success);
            } else {
                Error error = Error.builder().msg("Language Kaydedilmedi").build();
                resultService.getErrorMsgList().add(error);
            }

            resultService.setResponse(languageResponse);
            return resultService;
        }else if(OperationType.REMOVE.equals(request.getOperationType())){
            languageRepository.deleteById(request.getId());
            LanguageResponse languageResponse = LanguageResponse.builder().msg("Language başarılı silindi").build();
            resultService.setResponse(languageResponse);
            return resultService;
        }else if(OperationType.SEARCH.equals(request.getOperationType())){


            List<Language> languageList = languageRepository.findLanguageByLangIs(request.getLang());
            List<LanguageDto> languageDtoList = new ArrayList<>();
            languageList.forEach(item->{
                LanguageDto languageDto = new LanguageDto();
                languageDto.setId(item.getId());
                languageDto.setKey(item.getKey());
                languageDto.setTableName(item.getTableName());
                languageDto.setLang(item.getLang());
                languageDto.setValue(item.getValue());
                languageDto.setPageName(item.getPageName());
                languageDtoList.add(languageDto);
            });

            LanguageResponse languageResponse = LanguageResponse.builder().languageDtoList(languageDtoList).msg("Language search başarılı yapıldı.").build();

            resultService.setResponse(languageResponse);
            return resultService;
        }else{
            LanguageResponse languageResponse = LanguageResponse.builder().msg("Beklenmeyen bir seçenek").build();
            resultService.setResponse(languageResponse);
            return resultService;
        }

    }
}
