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
                        childColumns = "blocker_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "blocked_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index(
                        value = {"blocker_id", "blocked_id"},
                        unique = true
                )
        }
)
public class Block {

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "blocker_id")
    private long blockerId;

    @ColumnInfo(name = "blocked_id")
    private long blockedId;

    @NonNull
    @ColumnInfo(name = "created_at")
    private Instant createdAt;

    public Block(long id, long blockerId, long blockedId, @NonNull Instant createdAt) {
        this.id = id;
        this.blockerId = blockerId;
        this.blockedId = blockedId;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBlockerId() {
        return blockerId;
    }

    public void setBlockerId(long blockerId) {
        this.blockerId = blockerId;
    }

    public long getBlockedId() {
        return blockedId;
    }

    public void setBlockedId(long blockedId) {
        this.blockedId = blockedId;
    }

    @NonNull
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Instant createdAt) {
        this.createdAt = createdAt;
    }
}
