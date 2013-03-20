package org.jonyframework.examples.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-3-4
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DashboardController {
    /**
     * 后台管理登录页面
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }
}
