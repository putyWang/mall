package com.ego.commons.Configuration;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/7 11:36
 * @description：自定义返回结果类型
 * @modified By：
 * @version: $
 */
public class HttpResult {

    //响应状态码
    private int code;

    //响应体
    private String body;

    public HttpResult() {
    }

    public HttpResult(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
