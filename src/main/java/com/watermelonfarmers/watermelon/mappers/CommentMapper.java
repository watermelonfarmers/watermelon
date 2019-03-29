package com.watermelonfarmers.watermelon.mappers;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import com.watermelonfarmers.watermelon.models.comment.CommentResponse;

public class CommentMapper {
    public static CommentResponse mapCommentEntityToCommentResponse(CommentEntity commentEntity) {
        CommentResponse commentResponse = new CommentResponse();

        if (null != commentEntity.getId()){
            commentResponse.setId(commentEntity.getId());
        }

        if (null != commentEntity.getContent()) {
            commentResponse.setContent(commentEntity.getContent());
        }

        if (null != commentEntity.getCreate_time()) {
            commentResponse.setCreateTime(commentEntity.getCreate_time());
        }

        if (null != commentEntity.getLast_update_time()) {
            commentResponse.setLastModifiedTime(commentEntity.getLast_update_time());
        }

        if (null != commentEntity.getUser()) {
            commentResponse.setUser(UserMapper.mapUserEntityToUserResponse(commentEntity.getUser()));
        }

        return commentResponse;
    }
}
