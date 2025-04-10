package com.cakmak.abc.account.service;

import com.cakmak.abc.account.repository.dao.Role;
import com.cakmak.abc.account.web.CreateRoleRequest;

import java.util.List;

/**
 * @author: Halil Cakmak, Date : 2019-09-27
 */
public interface RoleService {

  String createRole(CreateRoleRequest createRoleRequest);

  List<Role> getAllRoles();
}
