package com.watermelonfarmers.watermelon.processors;

import com.watermelonfarmers.watermelon.entities.CommentEntity;
import com.watermelonfarmers.watermelon.mappers.CommentMapper;
import com.watermelonfarmers.watermelon.models.comment.CommentRequest;
import com.watermelonfarmers.watermelon.models.comment.CommentResponse;
import com.watermelonfarmers.watermelon.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CommentProcessor {
    private CommentRepository commentRepository;

    @Autowired
    public CommentProcessor(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ResponseEntity createComment(CommentRequest request) {
        CommentEntity commentEntity = CommentMapper.mapCommentRequestToCommentEntity(request);
        commentRepository.save(commentEntity);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<CommentResponse> getCommentById(Long id) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        if(commentEntity.isPresent()) {
            CommentResponse comment = CommentMapper.mapCommentEntityToCommentResponse(commentEntity.get());
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity deleteComment(Long id) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        if (commentEntity.isPresent()) {
            commentRepository.delete(commentEntity.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



