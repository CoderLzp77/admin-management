package com.utils;

import org.springframework.stereotype.Component;

@Component
public class R {
    private int status;
    private String message;
    private Object data;

    public R success(Object data){
        this.setMessage("成功");
        this.setStatus(200);
        this.setData(data);
        return this;
    }
    public R error(){
        this.setStatus(404);
        this.setMessage("失败");
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R status(int status) {
        this.setStatus(status);
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
