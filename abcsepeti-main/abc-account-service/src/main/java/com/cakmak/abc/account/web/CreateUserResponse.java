package com.cakmak.abc.account.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Halil Cakmak, Date : 2019-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserResponse {

  private String userId;
  private String userName;

}
