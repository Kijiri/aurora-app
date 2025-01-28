package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "user_id",
                onDelete = ForeignKey.CASCADE
        )
)
public class Comment {
    @PrimaryKey
    private long id;
    
    @ColumnInfo(name = "parent_id")
    private Long parentId;
    
    @ColumnInfo(name = "user_id")
    private long userId;
    
    @NonNull
    private String text;
    
    @NonNull
    private Instant createdAt;
    
    private boolean isEdited;
    
    public Comment(@NonNull String text, @NonNull Instant createdAt, long id) {
        this.text = text;
        this.createdAt = createdAt;
        this.id = id;
    }
}
