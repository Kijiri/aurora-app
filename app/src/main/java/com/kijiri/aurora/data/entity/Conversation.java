package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;

@Entity
public class Conversation {
    
    @PrimaryKey
    private long id;
    
    @NonNull
    private String title;
    
    @ColumnInfo(name = "avatar_url")
    private String avatarUrl;
    
    @NonNull
    @ColumnInfo(name = "created_at")
    private Instant createdAt;

    public Conversation(long id, @NonNull String title, @NonNull Instant createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @NonNull
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Instant createdAt) {
        this.createdAt = createdAt;
    }
}
