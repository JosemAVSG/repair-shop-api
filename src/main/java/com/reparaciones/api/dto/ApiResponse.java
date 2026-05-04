package com.reparaciones.api.dto;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private T data;
    private Meta meta;

    public ApiResponse() {}

    public ApiResponse(T data) {
        this.data = data;
        this.meta = new Meta(true, "OK");
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data);
    }

    public static <T> ApiResponse<T> error(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.meta = new Meta(false, message);
        return response;
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public Meta getMeta() { return meta; }
    public void setMeta(Meta meta) { this.meta = meta; }

    public static class Meta {
        private boolean success;
        private String message;
        private LocalDateTime timestamp;

        public Meta() {}

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
            this.timestamp = LocalDateTime.now();
        }

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    }
}