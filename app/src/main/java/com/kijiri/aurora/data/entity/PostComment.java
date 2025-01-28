package com.kijiri.aurora.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(
        primaryKeys = {"post_id", "comment_id"},
        foreignKeys = {
                @ForeignKey(
                        entity = Post.class,
                        parentColumns = "id",
                        childColumns = "post_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Comment.class,
                        parentColumns = "id",
                        childColumns = "comment_id",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class PostComment {
    private long id;
    @ColumnInfo(name = "post_id")
    private long postId;

    @ColumnInfo(name = "comment_id")
    private long commentId;
}
