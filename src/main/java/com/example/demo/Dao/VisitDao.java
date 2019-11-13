package com.example.demo.Dao;

import com.example.demo.Entity.Visit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户访问记录(Visit)表数据库访问层
 *
 * @author 庄茂森
 * @since 2019-10-10 19:48:07
 */
@Mapper
public interface VisitDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Visit queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Visit> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param visit 实例对象
     * @return 对象列表
     */
    List<Visit> queryAll(Visit visit);

    /**
     * 新增数据
     *
     * @param visit 实例对象
     * @return 影响行数
     */
    int insert(Visit visit);

    /**
     * 修改数据
     *
     * @param visit 实例对象
     * @return 影响行数
     */
    int update(Visit visit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Integer getTodayVisitCount();

    Integer getAllVisitCount();
}