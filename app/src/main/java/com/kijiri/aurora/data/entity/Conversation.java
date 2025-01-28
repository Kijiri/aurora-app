package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
