package com.kijiri.aurora.data.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.PostLike;
import com.kijiri.aurora.data.entity.User;

public class LikeWithUser {

    @Embedded
    public PostLike like;

    @Relation(
            parentColumn = "user_id",
            entityColumn = "id"
    )
    public User user;
}
