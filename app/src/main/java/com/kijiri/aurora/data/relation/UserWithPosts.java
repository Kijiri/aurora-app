package com.kijiri.aurora.data.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.Post;
import com.kijiri.aurora.data.entity.User;

import java.util.List;

public class UserWithPosts {
    @Embedded
    public User user;

    @Relation(
            parentColumn = "id",
            entityColumn = "post_id"
    )
    public List<Post> posts;
}
