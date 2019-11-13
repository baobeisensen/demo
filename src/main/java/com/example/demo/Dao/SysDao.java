package com.example.demo.Dao;

import com.example.demo.Entity.Sys;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 系统配置文件(Sys)表数据库访问层
 *
 * @author 庄茂森
 * @since 2019-10-10 11:00:41
 */
@Mapper
public interface SysDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sys queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sys> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sys 实例对象
     * @return 对象列表
     */
    List<Sys> queryAll(Sys sys);

    /**
     * 新增数据
     *
     * @param sys 实例对象
     * @return 影响行数
     */
    int insert(Sys sys);

    /**
     * 修改数据
     *
     * @param sys 实例对象
     * @return 影响行数
     */
    int update(Sys sys);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Sys getDatabaseInfo();

    String getUplockPassword();
}