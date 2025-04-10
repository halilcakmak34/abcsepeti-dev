package com.cakmak.abc.account.service;

import com.cakmak.abc.account.web.MapRoleToUsersRequest;
import com.cakmak.abc.account.web.MapUserToRolesRequest;

/**
 * @author: Halil Cakmak, Date : 2019-09-27
 */
public interface UserRoleService {

  void mapUserToRoles(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void removeRolesFromUser(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void mapRoleToUsers(String roleName, MapRoleToUsersRequest mapRoleToUsersRequest);
}
