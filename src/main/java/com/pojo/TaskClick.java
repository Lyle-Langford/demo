package com.pojo;


import java.io.Serializable;

/**
 * @author: Lyle
 * @date: 2020/9/24
 * @description: 任务点击记录
 **/

public class TaskClick implements Serializable {

    private Integer id;
    private Integer taskId; //任务id
    private Integer userId; //用户id
    private String userName; //用户名

    public TaskClick(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
