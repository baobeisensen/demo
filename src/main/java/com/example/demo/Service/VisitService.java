package com.example.demo.Service;

import com.example.demo.Entity.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户访问记录(Visit)表服务接口
 *
 * @author 庄茂森
 * @since 2019-10-10 19:48:08
 */
@Service
public interface VisitService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Visit queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Visit> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    Integer insert(Visit visit);

    /**
     * 修改数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    Visit update(Visit visit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Visit getVisitCount();
}