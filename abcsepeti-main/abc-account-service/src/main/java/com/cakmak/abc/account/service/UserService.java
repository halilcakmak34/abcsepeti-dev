package com.cakmak.abc.account.service;

import com.cakmak.abc.account.web.CreateUserRequest;
import com.cakmak.abc.account.web.GetUserInfoResponse;
import com.cakmak.abc.account.web.GetUserResponse;
import com.cakmak.abc.account.web.UpdateUserRequest;
import com.cakmak.abc.account.web.UpdateUserRequestFromAdmin;

import java.util.List;

/**
 * @author: Halil Cakmak, Date : 2019-09-27
 */
public interface UserService {

  String createUser(CreateUserRequest createUserRequest);

  GetUserResponse getUserByUserName(String userName);

  GetUserResponse getUserByUserId(String userId);

  GetUserInfoResponse getUserInfo();

  void updateUserInfo(UpdateUserRequest updateUserRequest);

  void deleteUserById(String userId);

  List<GetUserResponse> getAllUsers();

  void updateUser(String userId, UpdateUserRequestFromAdmin updateUserRequestFromAdmin);
}
