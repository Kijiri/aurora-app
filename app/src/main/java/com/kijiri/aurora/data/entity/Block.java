package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
