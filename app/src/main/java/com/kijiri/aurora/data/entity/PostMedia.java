package com.kijiri.aurora.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Post.class,
                        parentColumns = "id",
                        childColumns = "post_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Media.class,
                        parentColumns = "id",
                        childColumns = "media_id",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class PostMedia {
    @PrimaryKey
    private long id;
    @ColumnInfo(name = "post_id")
    private long postId;
    @ColumnInfo(name = "media_id")
    private long mediaId;
    
    @ColumnInfo(name = "grid_row")
    private int row;

    @ColumnInfo(name = "grid_col")
    private int col;

    private int length;
    private int height;

    public PostMedia(long id, long postId, long mediaId, int row, int col, int length, int height) {
        this.id = id;
        this.postId = postId;
        this.mediaId = mediaId;
        this.row = row;
        this.col = col;
        this.length = length;
        this.height = height;
    }

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

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
