package com.example.demo.Entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户访问记录(Visit)实体类
 *hyy15918335643
 * @author 庄茂森
 * @since 2019-10-10 19:48:07
 */
@Data
public class Visit implements Serializable {
    private static final long serialVersionUID = -13479044529726500L;
    
    private Integer id;
    //访问用户的IP地址
    private String ip;
    //访问的时间
    private Date createTime;
    //今日访问量
    private Integer todayVisitCount;
    //访问总量
    private Integer allVisitCount;


}