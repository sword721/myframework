package org.jonyframework.examples.demo.controller;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.jonyframework.examples.demo.entity.User;
import org.jonyframework.examples.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * 用户控制器类
 * 负责打开登录、登出、注册等用户页面
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    /**
     * UserService
     */
    @Autowired
    private UserService userService;

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "account/login";
    }

    /**
     * 用户登录出错后返回登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginFail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return "account/login";
    }

    /**
     * 进入用户注册页面
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "account/register";
    }

    /**
     * 处理用户注册请求
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, RedirectAttributes redirectAttributes) {
        userService.registerUser(user);
        redirectAttributes.addAttribute("username", user.getLoginName());
        return "redirect:/login";
    }

    /**
     * ajax请求校验账号的唯一性
     * @param loginName
     * @return
     */
    @RequestMapping(value = "/register/checkLoginName")
    @ResponseBody
    public String checkLoginName(@RequestParam("loginName") String loginName) {
        if (userService.findUserByLoginName(loginName) == null) {
            return "true";
        } else {
            return "false";
        }
    }
}
