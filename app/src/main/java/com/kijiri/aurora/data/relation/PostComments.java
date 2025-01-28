package com.kijiri.aurora.data.relation;

import androidx.room.Junction;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.Comment;
import com.kijiri.aurora.data.entity.PostComment;

import java.util.List;

public class PostComments {
    public long postId;

    @Relation(
            entity = Comment.class,
            parentColumn = "postId",
            entityColumn = "id",
            associateBy = @Junction(
                    value = PostComment.class,
                    parentColumn = "post_id",
                    entityColumn = "comment_id"
            )
    )
    public List<CommentWithUser> comments;
}
