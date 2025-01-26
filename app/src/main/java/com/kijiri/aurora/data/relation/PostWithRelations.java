package com.kijiri.aurora.data.relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.Category;
import com.kijiri.aurora.data.entity.Comment;
import com.kijiri.aurora.data.entity.Post;
import com.kijiri.aurora.data.entity.PostCategory;
import com.kijiri.aurora.data.entity.PostComment;
import com.kijiri.aurora.data.entity.PostContent;
import com.kijiri.aurora.data.entity.PostLike;
import com.kijiri.aurora.data.entity.PostMedia;
import com.kijiri.aurora.data.entity.PostTag;
import com.kijiri.aurora.data.entity.Tag;
import com.kijiri.aurora.data.entity.User;

import java.util.List;

public class PostWithRelations {
    @Embedded
    public Post post;

    @Relation(
            entity = Comment.class,
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(
                    value = PostComment.class,
                    parentColumn = "post_id",
                    entityColumn = "comment_id"
            )
    )
    public List<Comment> comments;


    @Relation(
            parentColumn = "id",
            entityColumn = "post_id"
    )
    public List<PostContent> contentList;

    @Relation(
            parentColumn = "id",
            entityColumn = "post_id"
    )
    public List<PostMedia> postMediaList;
    
    @Relation(
            parentColumn = "user_id",
            entityColumn = "id"
    )
    public User user;

    @Relation(
            entity = Category.class,
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(
                    value = PostCategory.class,
                    parentColumn = "post_id",
                    entityColumn = "category_id"
            )
    )
    public List<Category> categories;

    @Relation(
            entity = Tag.class,
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(
                    value = PostTag.class,
                    parentColumn = "post_id",
                    entityColumn = "tag_id"
            )
    )
    public List<Tag> tags;
    
    @Relation(
            parentColumn = "id",
            entityColumn = "post_id"
    )
    public List<PostLike> likes;
}
