package com.kijiri.aurora.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Post.class,
                        parentColumns = "id",
                        childColumns = "post_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Tag.class,
                        parentColumns = "id",
                        childColumns = "tag_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index(value = {"post_id", "tag_id"}, unique = true)
        }
)
public class PostTag {
    @PrimaryKey
    private long id;
    @ColumnInfo(name = "post_id")
    private long postId;
    @ColumnInfo(name = "tag_id")
    private long tagId;

    public PostTag(long id, long postId, long tagId) {
        this.id = id;
        this.postId = postId;
        this.tagId = tagId;
    }
}
