package com.estiasi.user.controller;

import com.estiasi.user.model.User;
import com.estiasi.user.service.UserService;
import com.estiasi.user.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User findById(@RequestParam("id") Integer id) throws Exception {
        return userService.get(id);
    }

    @PostMapping
    public User createRestaurant(@RequestBody UserVO userVO) throws Exception {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        return userService.add(user);
    }

}
