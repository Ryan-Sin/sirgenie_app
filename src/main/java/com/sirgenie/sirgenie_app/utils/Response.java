package com.sirgenie.sirgenie_app.utils;

import lombok.Data;

/**
 * @author Ryan
 * @description 클라이언트에게 반환되는 Class
 */
@Data
public class Response<T>{

    private boolean success; // 성공 여부
    private String message; // 메시지
    private T data; // 결과 값

    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}