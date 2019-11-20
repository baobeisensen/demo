package com.example.demo.Dao;
import	java.awt.Menu;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author 庄茂森
 * @since 2019-08-24 09:35:29
 */
@Mapper
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    User queryById(Integer id);




    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(@Param("user") User user);

    /**
     * 通过主键删除数据
     *
     * @return 影响行数
     */
    int deleteById( );

    /**
     * 根据用户名密码查询
     */
    User queryByUserNameAndPwd(@Param("userName")String userName,
                               @Param("pwd")String pwd);

}