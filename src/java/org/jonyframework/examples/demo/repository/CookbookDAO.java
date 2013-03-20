package org.jonyframework.examples.demo.repository;

import org.jonyframework.examples.demo.entity.Cookbook;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 食谱数据持久操作类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-2-28
 * Time: 下午2:45
 * To change this template use File | Settings | File Templates.
 */
public interface CookbookDAO extends PagingAndSortingRepository<Cookbook, Long>, JpaSpecificationExecutor<Cookbook> {
    Cookbook findByName(String name);

}
