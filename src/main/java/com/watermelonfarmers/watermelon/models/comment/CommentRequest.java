package com.watermelonfarmers.watermelon.models.comment;

import java.time.LocalDateTime;

public class CommentRequest {

    private LocalDateTime createTime;
    private LocalDateTime lastModifiedTime;
    private String content;
    private Long userId;

    public CommentRequest() {
    }

    public CommentRequest( LocalDateTime createTime, LocalDateTime lastModifiedTime, String content, Long userId, Long requirementId) {
        this.createTime = createTime;
        this.lastModifiedTime = lastModifiedTime;
        this.content = content;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
