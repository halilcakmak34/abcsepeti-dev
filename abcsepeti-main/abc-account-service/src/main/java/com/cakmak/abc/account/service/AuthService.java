package com.cakmak.abc.account.service;

import com.cakmak.abc.account.web.CreateOAuthClientRequest;
import com.cakmak.abc.account.web.CreateOAuthClientResponse;
import com.cakmak.abc.account.web.CreateUserResponse;
import com.cakmak.abc.account.web.SignUpRequest;

/**
 * @author: Halil Cakmak, Date : 2019-09-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
