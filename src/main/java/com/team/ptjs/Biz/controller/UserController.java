package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Biz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/user" )
public class UserController {

    private final UserService userService;
    /**
     * 请求登录
     *
     * @param userDto
     * @return
     */
    @PostMapping("/login" )
    public R Login(@RequestBody UserDto userDto) {
        return userService.Login(userDto);
    }
}
