package com.kijiri.aurora.data.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.Comment;
import com.kijiri.aurora.data.entity.User;

public class CommentWithUser {
    @Embedded
    public Comment comment;
    
    @Relation(
            parentColumn = "user_id",
            entityColumn = "id"
    )
    public User user;
}
