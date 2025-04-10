package com.cakmak.abc.account.repository;

import com.cakmak.abc.account.repository.dao.OAuthClient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Halil Cakmak, Date : 2019-05-18
 */
public interface OAuthClientRepository extends CrudRepository<OAuthClient, Long> {

}
