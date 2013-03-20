package org.jonyframework.examples.demo.service;

import org.jonyframework.examples.demo.entity.User;
import org.jonyframework.examples.demo.repository.UserDAO;
import org.jonyframework.utils.DateProvider;
import org.jonyframework.utils.Digests;
import org.jonyframework.utils.Encodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户业务逻辑处理类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class UserService {
    //日志记录对象
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    //加密算法
    public static final String HASH_ALGORITHM = "SHA-1";

    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    //用户持久操作类
    private UserDAO userDAO;

    private DateProvider dateProvider = DateProvider.DEFAULT;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUser() {
        return (List<User>)userDAO.findAll();
    }

    /**
     * 根据用户ID获取用户信息的操作方法
     * @param userId
     * @return
     */
    public User getUser(long userId) {
        return userDAO.findOne(userId);
    }

    /**
     * 根据用户登陆账号返回用户信息的操作方法
     * @param loginName
     * @return User
     */
    public User findUserByLoginName(String loginName) {
        return userDAO.findByLoginName(loginName);
    }

    /**
     * 用户注册的操作方法
     * @param user
     */
    @Transactional(readOnly = false)
    public void registerUser(User user) {
        entryptPassword(user);
        user.setLastLoginTime(dateProvider.getDate());
        user.setCreatedAt(dateProvider.getDate());
        userDAO.save(user);
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }
}
