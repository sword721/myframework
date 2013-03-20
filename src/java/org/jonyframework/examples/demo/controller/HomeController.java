package org.jonyframework.examples.demo.controller;

import org.jonyframework.examples.demo.entity.Cookbook;
import org.jonyframework.examples.demo.service.cookbook.CookbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 首页控制器
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-2-20
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {
    @Autowired
    private CookbookService cookbookService;

    /**
     * 进入首页
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Cookbook> cookbooks = cookbookService.getAllCookbooks();
        model.addAttribute("cookbooks", cookbooks);
        return "index";
    }
}
