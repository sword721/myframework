package org.jonyframework.examples.demo.controller.admin;

import com.google.common.collect.Maps;
import org.jonyframework.examples.demo.entity.CookMaterial;
import org.jonyframework.examples.demo.service.cookbook.CookMaterialService;
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

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * 食材后台管理控制器
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-3-12
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CookMaterialAdminController {
    @Autowired
    private CookMaterialService cookMaterialService;

    private DateProvider dateProvider = DateProvider.DEFAULT;

    private static final int PAGE_SIZE = 20;

    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("name", "名称");
    }

    /**
     * 进入食材管理的页面
     * @param sortType
     * @param pageNumber
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/cookmaterials", method = RequestMethod.GET)
    public String cookMaterialManageIndex(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                                          @RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                          Model model, ServletRequest request) {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<CookMaterial> cookMaterials = cookMaterialService.getCookMaterials(
                searchParams, pageNumber, PAGE_SIZE, sortType);
        model.addAttribute("cookMaterials", cookMaterials);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        // 将搜索条件编码成字符串，用于排序，分页的URL
        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
        return "admin/cookmaterials/index";
    }

    /**
     * 进入新增食材的页面
     * @return
     */
    @RequestMapping(value = "/admin/cookmaterials/new", method = RequestMethod.GET)
    public String newCookMaterial() {
        return "admin/cookmaterials/new";
    }

    /**
     * 进入编辑食材的页面
     * @return
     */
    @RequestMapping(value = "/admin/cookmaterials/update/{id}", method = RequestMethod.GET)
    public String updateCookMaterial(@PathVariable("id") Long id, Model model) {
        CookMaterial cookMaterial = cookMaterialService.getCookMaterial(id);
        model.addAttribute("cookMaterial", cookMaterial);
        model.addAttribute("action", "update");
        return "admin/cookmaterials/edit";
    }

    /**
     * 保存更新食材信息
     * @return
     */
    @RequestMapping(value = "/admin/cookmaterials/update", method = RequestMethod.POST)
    public String updateCookMaterial(@Valid CookMaterial updateCookMaterial) {
        return "redirect:/admin/cookmaterials";
    }
}
