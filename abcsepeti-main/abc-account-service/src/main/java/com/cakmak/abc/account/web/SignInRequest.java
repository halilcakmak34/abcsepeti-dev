package com.cakmak.abc.account.web;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Halil Cakmak, Date : 2019-05-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {

  @NotBlank
  private String usernameOrEmail;

  @NotBlank
  private String password;
}

