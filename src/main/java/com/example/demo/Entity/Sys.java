package com.example.demo.Entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统配置文件(Sys)实体类
 *
 * @author 庄茂森
 * @since 2019-10-10 11:00:41
 */
@Data
public class Sys implements Serializable {
    private static final long serialVersionUID = 205383880636076285L;
    
    private Integer id;

    private String name;

    private String value;
    //mysql版本
    private String version;


}