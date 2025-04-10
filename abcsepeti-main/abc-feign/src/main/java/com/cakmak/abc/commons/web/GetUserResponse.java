package com.cakmak.abc.commons.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Halil Cakmak,
 * Date : 2019-06-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {

    private String userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

}
