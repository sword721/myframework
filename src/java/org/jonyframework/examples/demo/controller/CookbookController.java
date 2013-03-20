package org.jonyframework.examples.demo.controller;

import org.jonyframework.examples.demo.entity.Cookbook;
import org.jonyframework.examples.demo.service.cookbook.CookbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 食谱类相关处理控制
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-3-11
 * Time: 下午4:37
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CookbookController {
    @Autowired
    private CookbookService cookbookService;

    /**
     * 显示食谱信息页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/cookbooks/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
        Cookbook cookbook = cookbookService.getCookbook(id);
        model.addAttribute("cookbook", cookbook);
        return "cookbooks/show";
    }
}
