package com.kijiri.aurora.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {
    
    @PrimaryKey
    private Long id;
    
    //TODO relationships
    
    private String title;
    private String previewText;
    private Integer cost;

    //TODO enum
    
    private Long likeCount;
    private Long commentCount;
    private Long viewCount;
    private boolean isEdited;
    
}
