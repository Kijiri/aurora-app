package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.kijiri.aurora.data.enums.NotificationType;

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
public class Notification {
    
    @PrimaryKey
    private long id;
    
    @ColumnInfo(name = "user_id")
    private long userId;
    
    @NonNull
    @ColumnInfo(name = "type")
    private NotificationType notificationType;

    @NonNull
    @ColumnInfo(name = "created_at")
    private Instant createdAt;
    
    @ColumnInfo(name = "notification_id")
    private long notificationId;

    @ColumnInfo(name = "is_read")
    private boolean isRead;

    public Notification(long id, long userId, @NonNull NotificationType notificationType, @NonNull Instant createdAt, long notificationId, boolean isRead) {
        this.id = id;
        this.userId = userId;
        this.notificationType = notificationType;
        this.createdAt = createdAt;
        this.notificationId = notificationId;
        this.isRead = isRead;
    }
}
