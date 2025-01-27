package com.kijiri.aurora.data.relation;

import androidx.room.Relation;

import com.kijiri.aurora.data.entity.PostLike;

import java.util.List;

public class PostLikes {

    public long postId; 

    @Relation(
            entity = PostLike.class,
            parentColumn = "postId",
            entityColumn = "post_id"
    )
    public List<LikeWithUser> likes;
}
