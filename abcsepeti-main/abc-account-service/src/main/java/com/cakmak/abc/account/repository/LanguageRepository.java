package com.cakmak.abc.account.repository;

import com.cakmak.abc.account.repository.dao.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, String> {
    List<Language> findLanguageByLangIs(String lang);
}
