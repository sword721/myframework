package org.jonyframework.examples.demo.repository;

import org.jonyframework.examples.demo.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 用户数据库持久操作类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO extends PagingAndSortingRepository<User, Long> {
    User findByLoginName(String loginName);
}
