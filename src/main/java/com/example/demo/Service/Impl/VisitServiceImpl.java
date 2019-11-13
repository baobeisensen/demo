package com.example.demo.Service.Impl;

import com.example.demo.Dao.VisitDao;
import com.example.demo.Entity.Visit;
import com.example.demo.Service.VisitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户访问记录(Visit)表服务实现类
 *
 * @author 庄茂森
 * @since 2019-10-10 19:48:08
 */
@Service("visitService")
public class VisitServiceImpl implements VisitService {
    @Resource
    private VisitDao visitDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Visit queryById(Integer id) {
        return this.visitDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Visit> queryAllByLimit(int offset, int limit) {
        return this.visitDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(Visit visit) {
        int i = this.visitDao.insert(visit);
        return i;
    }

    /**
     * 修改数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    @Override
    public Visit update(Visit visit) {
        this.visitDao.update(visit);
        return this.queryById(visit.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.visitDao.deleteById(id) > 0;
    }

    @Override
    public Visit getVisitCount() {
        Visit v = new Visit();
        v.setTodayVisitCount(visitDao.getTodayVisitCount());
        v.setAllVisitCount(visitDao.getAllVisitCount());
        return v;
    }
}