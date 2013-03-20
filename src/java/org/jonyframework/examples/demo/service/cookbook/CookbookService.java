package org.jonyframework.examples.demo.service.cookbook;

import org.jonyframework.examples.demo.entity.Cookbook;
import org.jonyframework.examples.demo.repository.CookbookDAO;
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
 * Date: 13-2-28
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class CookbookService {

    private CookbookDAO cookbookDAO;

    @Autowired
    public void setCookbookDAO(CookbookDAO cookbookDAO) {
        this.cookbookDAO = cookbookDAO;
    }

    public Cookbook getCookbook(Long id) {
        return cookbookDAO.findOne(id);
    }

    @Transactional(readOnly = false)
    public void saveCookbook(Cookbook entity) {
        cookbookDAO.save(entity);
    }

    @Transactional(readOnly = false)
    public void deleteCookbook(Long id) {
        cookbookDAO.delete(id);
    }

    /**
     * 获取所有食谱的操作方法
     *
     * @return
     */
    public List<Cookbook> getAllCookbooks() {
        return (List<Cookbook>) cookbookDAO.findAll();
    }

    /**
     * 分页获取食谱数据
     * @param searchParams 查询参数
     * @param pageNumber 页数
     * @param pageSize 总页数
     * @param sortType 排序类型
     * @return
     */
    public Page<Cookbook> getCookbook(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                      String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Cookbook> spec = buildSpecification(searchParams);

        return cookbookDAO.findAll(spec, pageRequest);
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
    private Specification<Cookbook> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//        filters.put("cookbook.id", new SearchFilter("cookbook.id", SearchFilter.Operator.EQ, userId));
        Specification<Cookbook> spec = DynamicSpecifications.bySearchFilter(filters.values(), Cookbook.class);
        return spec;
    }
}
