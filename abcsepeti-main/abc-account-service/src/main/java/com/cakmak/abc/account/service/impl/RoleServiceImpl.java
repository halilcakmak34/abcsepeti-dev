package com.cakmak.abc.account.service.impl;

import com.cakmak.abc.account.repository.RoleRepository;
import com.cakmak.abc.account.repository.dao.Role;
import com.cakmak.abc.account.web.CreateRoleRequest;
import com.cakmak.abc.account.service.RoleService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Halil Cakmak, Date : 2019-06-30
 */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleRepository roleRepository;


  @Override
  public String createRole(CreateRoleRequest createRoleRequest) {

    Role role = Role.builder()
        .roleName(createRoleRequest.getRoleName())
        .roleDescription(createRoleRequest.getRoleDescription())
        .build();

    Role savedRole = roleRepository.save(role);
    return savedRole.getId();
  }

  @Override
  public List<Role> getAllRoles() {
    List<Role> allRoles = roleRepository.findAll();
    return allRoles;
  }
}
