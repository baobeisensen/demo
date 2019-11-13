package com.example.demo.Entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author 庄茂森
 * @since 2019-08-24 09:35:29
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 410351051060707275L;
    
    private Integer id;
    
    private String name;
    
    private Integer age;

    private String pwd;
}