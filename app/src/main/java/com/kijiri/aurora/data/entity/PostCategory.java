package com.kijiri.aurora.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(
        primaryKeys = {"post_id", "category_id"},
        foreignKeys = {
                @ForeignKey(
                        entity = Post.class,
                        parentColumns = "id",
                        childColumns = "post_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Category.class,
                        parentColumns = "id",
                        childColumns = "category_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index(value = {"post_id", "category_id"}, unique = true)
        }
)
public class PostCategory {
    
    private long id;
    @ColumnInfo(name = "post_id")
    private long postId;
    @ColumnInfo(name = "category_id")
    private long categoryId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
