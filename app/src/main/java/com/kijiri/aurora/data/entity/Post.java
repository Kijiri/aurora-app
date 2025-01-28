package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kijiri.aurora.data.enums.PublishStatus;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post {

    @PrimaryKey
    private long id;
    
    @NonNull
    private String title;
    @NonNull
    private String previewText;
    
    private int cost;
    
    @ColumnInfo(name = "user_id")
    private long userId;

    @ColumnInfo(name = "status")
    private PublishStatus publishStatus;
    
    private long likeCount;

    private long commentCount;

    private long viewCount;
    
    private boolean edited;

    @NonNull
    private Instant createdAt;

    public Post(long id,
                @NonNull String title,
                @NonNull String previewText, long userId,
                int cost, PublishStatus publishStatus,
                long likeCount,
                long commentCount,
                long viewCount,
                boolean edited,
                @NonNull Instant createdAt) {
        this.id = id;
        this.title = title;
        this.previewText = previewText;
        this.userId = userId;
        this.cost = cost;
        this.publishStatus = publishStatus;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.edited = edited;
        this.createdAt = createdAt;
    }
}
