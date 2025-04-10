package com.cakmak.abc.account.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author: Halil Cakmak, Date : 2019-09-27
 */
public interface AppUserDetailsService extends UserDetailsService {

  @Override
  UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException;

}
