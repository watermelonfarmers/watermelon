package com.watermelonfarmers.watermelon.controllers;

import com.watermelonfarmers.watermelon.models.comment.CommentRequest;
import com.watermelonfarmers.watermelon.models.comment.CommentResponse;
import com.watermelonfarmers.watermelon.processors.CommentProcessor;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/comments")
@Api(tags = "comments", description = "comments api")
public class CommentController {

    private CommentProcessor commentProcessor;

    @Autowired
    public CommentController(CommentProcessor commentProcessor) {
        this.commentProcessor = commentProcessor;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createComment(@RequestBody CommentRequest request) {
        return commentProcessor.createComment(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CommentResponse>> getComments() {
        return commentProcessor.getComments();
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
    public ResponseEntity<CommentResponse> getCommentById(@PathVariable Long commentId) {
        return commentProcessor.getCommentById(commentId);
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteComment(@PathVariable Long commentId) {
        return commentProcessor.deleteComment(commentId);
    }
}
