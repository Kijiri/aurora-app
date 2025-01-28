package com.kijiri.aurora.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = PostSection.class,
                        parentColumns = "id",
                        childColumns = "post_section_id",
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
    @ColumnInfo(name = "post_section_id")
    private long postSectionId;
    @ColumnInfo(name = "media_id")
    private long mediaId;
    
    @ColumnInfo(name = "grid_row")
    private int row;

    @ColumnInfo(name = "grid_col")
    private int col;

    private int length;
    private int height;

    public PostMedia(long id, long postSectionId, long mediaId, int row, int col, int length, int height) {
        this.id = id;
        this.postSectionId = postSectionId;
        this.mediaId = mediaId;
        this.row = row;
        this.col = col;
        this.length = length;
        this.height = height;
    }
}
