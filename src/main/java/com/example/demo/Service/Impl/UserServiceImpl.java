package com.example.demo.Service.Impl;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author 庄茂森
 * @since 2019-08-24 09:35:32
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        Integer id =  this.userDao.insert(user);
        return userDao.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.userDao.deleteById() > 0;
    }

    @Override
    public User query(String name, String pwd) {
        return userDao.queryByUserNameAndPwd(name,pwd);
    }
}