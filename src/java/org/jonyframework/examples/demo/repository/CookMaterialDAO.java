package org.jonyframework.examples.demo.repository;

import org.jonyframework.examples.demo.entity.CookMaterial;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-3-12
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public interface CookMaterialDAO extends PagingAndSortingRepository<CookMaterial, Long>,
        JpaSpecificationExecutor<CookMaterial> {
    CookMaterial findByName(String name);
}
