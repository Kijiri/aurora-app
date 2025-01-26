package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kijiri.aurora.data.enums.PublishStatus;

import java.time.Instant;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(@NonNull String previewText) {
        this.previewText = previewText;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public PublishStatus getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(PublishStatus publishStatus) {
        this.publishStatus = publishStatus;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    @NonNull
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Instant createdAt) {
        this.createdAt = createdAt;
    }
}
