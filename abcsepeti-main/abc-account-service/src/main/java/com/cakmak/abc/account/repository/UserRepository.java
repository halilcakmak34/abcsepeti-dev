package com.cakmak.abc.account.repository;


import com.cakmak.abc.account.repository.dao.User;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * @author: Halil Cakmak, Date : 2019-05-17
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUserName(String username);

  Optional<User> findByUserNameOrEmail(String uName, String eMail);

  Optional<User> findByUserId(String userId);

  void deleteByUserId(String userId);

  Boolean existsByUserName(String userName);

  Boolean existsByEmail(String email);

}
