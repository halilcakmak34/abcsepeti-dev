package com.cakmak.abc.account.web;

import com.cakmak.abc.account.repository.dao.Role;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Halil Cakmak, Date : 2019-10-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponse {

  private String userId;
  private String userName;
  private String firstName;
  private String lastName;
  private String email;
  private Set<Role> roles;

}
