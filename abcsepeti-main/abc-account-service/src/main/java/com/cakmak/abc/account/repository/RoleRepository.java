package com.cakmak.abc.account.repository;

import com.cakmak.abc.account.repository.dao.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Halil Cakmak, Date : 2019-05-17
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

  Optional<Role> findByRoleName(String name);

  Boolean existsByRoleName(String roleName);

  @Override
  List<Role> findAll();
}
