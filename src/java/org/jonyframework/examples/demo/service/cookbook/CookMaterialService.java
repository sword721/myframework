package org.jonyframework.examples.demo.service.cookbook;

import org.jonyframework.examples.demo.entity.CookMaterial;
import org.jonyframework.examples.demo.entity.Cookbook;
import org.jonyframework.examples.demo.repository.CookMaterialDAO;
import org.jonyframework.persistence.DynamicSpecifications;
import org.jonyframework.persistence.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-3-12
 * Time: 上午11:24
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class CookMaterialService {
    private CookMaterialDAO cookMaterialDAO;

    @Autowired
    public void setCookMaterialDAO(CookMaterialDAO cookMaterialDAO) {
        this.cookMaterialDAO = cookMaterialDAO;
    }

    /**
     * 根据Id获取食材信息
     * @param id
     * @return
     */
    public CookMaterial getCookMaterial(Long id) {
        return cookMaterialDAO.findOne(id);
    }

    /**
     * 保存食材信息
     * @param cookMaterial
     */
    @Transactional(readOnly = false)
    public void saveCookMaterial(CookMaterial cookMaterial) {
        cookMaterialDAO.save(cookMaterial);
    }

    /**
     * 根据ID删除食材
     * @param id
     */
    @Transactional(readOnly = false)
    public void deleteCookMaterial(Long id) {
        cookMaterialDAO.delete(id);
    }

    /**
     * 获取所有食材的操作方法
     * @return
     */
    public List<CookMaterial> getAllCookMaterials() {
        return (List<CookMaterial>)cookMaterialDAO.findAll();
    }

    /**
     * 分页获取食材数据
     * @return
     */
    public Page<CookMaterial> getCookMaterials(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                               String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<CookMaterial> spec = buildSpecification(searchParams);

        return cookMaterialDAO.findAll(spec, pageRequest);
    }

    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } else if ("name".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "name");
        }

        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }

    /**
     * 创建动态查询条件组合.
     */
    private Specification<CookMaterial> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//      filters.put("cookbook.id", new SearchFilter("cookbook.id", SearchFilter.Operator.EQ, userId));
        Specification<CookMaterial> spec = DynamicSpecifications.bySearchFilter(filters.values(), CookMaterial.class);
        return spec;
    }
}
