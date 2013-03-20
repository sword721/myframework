package org.jonyframework.examples.demo.controller.admin;

import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.jonyframework.examples.demo.entity.Cookbook;
import org.jonyframework.examples.demo.service.cookbook.CookbookService;
import org.jonyframework.utils.DateProvider;
import org.jonyframework.web.Servlets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * 食谱后台管理控制器类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-3-7
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CookbookAdminController implements ServletContextAware {
    @Autowired
    private CookbookService cookbookService;

    private ServletContext servletContext;

    private DateProvider dateProvider = DateProvider.DEFAULT;

    private static final int PAGE_SIZE = 20;

    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("name", "名称");
    }

    /**
     * 进入食谱管理首页
     *
     * @return
     */
    @RequestMapping(value = "/admin/cookbooks")
    public String cookbookManageIndex(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model,
                                      ServletRequest request) {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<Cookbook> cookbooks = cookbookService.getCookbook(searchParams, pageNumber, PAGE_SIZE, sortType);

        model.addAttribute("cookbooks", cookbooks);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        // 将搜索条件编码成字符串，用于排序，分页的URL
        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
        return "admin/cookbooks/index";
    }

    /**
     * 进入新增食谱页面
     * @return
     */
    @RequestMapping(value = "/admin/cookbooks/new", method = RequestMethod.GET)
    public String newCookbook() {
        return "admin/cookbooks/new";
    }

    /**
     * 新增食谱
     * @return
     */
    @RequestMapping(value = "/admin/cookbooks/create", method = RequestMethod.POST)
    public String createCookbook(@Valid Cookbook newCookbook, MultipartHttpServletRequest request,
                                 RedirectAttributes redirectAttributes) {
        newCookbook.setCreatedAt(dateProvider.getDate());
        MultipartFile file = request.getFile("intro_image");
        String path = servletContext.getRealPath("/");

        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File(path + "uploads\\images\\cookbooks\\" + file.getOriginalFilename()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        newCookbook.setIntro_img(servletContext.getContextPath() + "uploads/images/cookbooks/" + file.getOriginalFilename());
        cookbookService.saveCookbook(newCookbook);
        redirectAttributes.addFlashAttribute("message", "创建食谱成功");
        return "redirect:/admin/cookbooks";
    }

    /**
     * 进入更新食谱页面
     * @return
     */
    @RequestMapping(value = "/admin/cookbooks/update/{id}", method = RequestMethod.GET)
    public String updateCookbook(@PathVariable("id") Long id, Model model) {
        Cookbook cookbook = cookbookService.getCookbook(id);
        model.addAttribute("cookbook", cookbook);
        model.addAttribute("action", "update");
        return "admin/cookbooks/edit";
    }

    /**
     * 保存更新食谱信息
     * @return
     */
    @RequestMapping(value = "/admin/cookbooks/update", method = RequestMethod.POST)
    public String updateCookbook(@Valid Cookbook updateCookbook, RedirectAttributes redirectAttributes) {
        cookbookService.saveCookbook(updateCookbook);
        redirectAttributes.addFlashAttribute("message", "更新食谱成功");
        return "redirect:/admin/cookbooks";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        //To change body of implemented methods use File | Settings | File Templates.
        this.servletContext = servletContext;
    }
}

