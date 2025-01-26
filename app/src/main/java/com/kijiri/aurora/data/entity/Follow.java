package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.Instant;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "follower_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "followed_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index(
                        value = {"follower_id", "followed_id"},
                        unique = true
                )
        }
)
public class Follow {
    @PrimaryKey
    private long id;
    
    @ColumnInfo(name = "follower_id")
    private long followerId;

    @ColumnInfo(name = "followed_id")
    private long followedId;

    @NonNull
    @ColumnInfo(name = "created_at")
    private Instant createdAt;

    public Follow(long id, long followerId, long followedId, @NonNull Instant createdAt) {
        this.id = id;
        this.followerId = followerId;
        this.followedId = followedId;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(long followerId) {
        this.followerId = followerId;
    }

    public long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(long followedId) {
        this.followedId = followedId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
