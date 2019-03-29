package com.watermelonfarmers.watermelon.models.comment;

import com.watermelonfarmers.watermelon.models.users.UserResponse;

import java.time.LocalDateTime;

public class CommentResponse {

    private long id;
    private LocalDateTime createTime;
    private LocalDateTime lastModifiedTime;
    private String content;
    private UserResponse user;

    public CommentResponse() {
    }

    public CommentResponse(long id, LocalDateTime createTime, LocalDateTime lastModifiedTime, String content, UserResponse user) {
        this.id = id;
        this.createTime = createTime;
        this.lastModifiedTime = lastModifiedTime;
        this.content = content;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
