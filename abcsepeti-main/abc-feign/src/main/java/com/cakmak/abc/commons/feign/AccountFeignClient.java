package com.cakmak.abc.commons.feign;

import com.cakmak.abc.commons.web.GetUserInfoResponse;
import com.cakmak.abc.commons.web.GetUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Halil Cakmak,
 * Date : 2019-07-02
 */
@FeignClient("abc-account-service")
public interface AccountFeignClient {

    @GetMapping("/user")
    GetUserResponse getUserByUserName(@RequestParam("userName") String userName);

    @GetMapping("/user")
    GetUserResponse getUserById(@RequestParam("userId") String userId);

    @GetMapping("/userInfo")
    GetUserInfoResponse getUserInfo();

}
