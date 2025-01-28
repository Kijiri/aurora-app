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
        foreignKeys = @ForeignKey(
                entity = Post.class,
                parentColumns = "id",
                childColumns = "post_id",
                onDelete = ForeignKey.CASCADE
        )
)
public class PostSection {
    @PrimaryKey
    private long id;
    
    @ColumnInfo(name = "post_id")
    private long postId;
    
    private String title;
    
    private int cost;
    
}
