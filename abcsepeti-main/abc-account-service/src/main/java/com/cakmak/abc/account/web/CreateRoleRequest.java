package com.cakmak.abc.account.web;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Halil Cakmak, Date : 2019-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleRequest{

  @NotBlank
  private String roleName;
  @NotBlank
  private String roleDescription;

}
