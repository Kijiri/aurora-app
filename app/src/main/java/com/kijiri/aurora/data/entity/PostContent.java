package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(
        foreignKeys = @ForeignKey(
                entity = Post.class,
                parentColumns = "id",
                childColumns = "post_id",
                onDelete = ForeignKey.CASCADE
        )
)
public class PostContent {
    @PrimaryKey
    private long id;
    
    @NonNull
    private String content;

    @ColumnInfo(name = "post_id")
    private long postId;
    
    @ColumnInfo(name = "grid_row")
    private int row;
    
    
    @ColumnInfo(name = "grid_col")
    private int col;
    
    private int length;
    
    private int height;

    public PostContent(long id, @NonNull String content, int row, int col, int length, int height) {
        this.id = id;
        this.content = content;
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

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
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
