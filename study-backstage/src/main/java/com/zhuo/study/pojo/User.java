package com.zhuo.study.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user")
//因为是做前后端分离，而前后端数据交互用的是 json 格式。
// 那么 User 对象就会被转换为 json 数据。
// 而本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate,
// 在 jpa 工作过程中，就会创造代理类来继承 User ，并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性
// 所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class User {

    @Id
    //a，TABLE：使用一个特定的数据库表格来保存主键。
    //b，SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
    //c，IDENTITY：主键由数据库自动生成（主要是自动增长型）
    //d，AUTO：主键由程序控制。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

//    @Column(name = "username")
    String username;
//    @Column(name = "password")
    String password;

    public int getId(){

        return id;
    }
    public void setId(int id){

        this.id = id;
    }
    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
