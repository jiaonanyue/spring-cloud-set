package org.spring.cloud.controller;

import org.spring.cloud.enitiy.User;
import org.spring.cloud.server.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <ul>
 * <li>文件包名 : org.spring.cloud.controller</li>
 * <li>创建时间 : 2018/1/11 18:02</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author jiaonanyue
 * @version 2.0.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("add")
    public String add(){
        User user = new User();
        user.setSex("22");
        user.setAddress("四川成都");
        user.setUserName("张三");
        userService.add(user);

        return "保存数据";
    }

    @GetMapping("get")
    public User get(Long id){

        return userService.get(id);
    }
}
