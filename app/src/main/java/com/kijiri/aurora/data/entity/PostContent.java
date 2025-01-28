package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(
        foreignKeys = @ForeignKey(
                entity = PostSection.class,
                parentColumns = "id",
                childColumns = "post_section_id",
                onDelete = ForeignKey.CASCADE
        )
)
public class PostContent {
    @PrimaryKey
    private long id;
    
    @NonNull
    private String content;

    @ColumnInfo(name = "post_section_id")
    private long postSectionId;
    
    @ColumnInfo(name = "grid_row")
    private int row;
    
    
    @ColumnInfo(name = "grid_col")
    private int col;
    
    private int length;
    
    private int height;

    public PostContent(long id, @NonNull String content, long postSectionId, int row, int col, int length, int height) {
        this.id = id;
        this.content = content;
        this.postSectionId = postSectionId;
        this.row = row;
        this.col = col;
        this.length = length;
        this.height = height;
    }
}
