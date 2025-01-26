package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.kijiri.aurora.data.enums.NotificationType;

import java.time.Instant;

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

    public Notification(long id, long userId, @NonNull NotificationType notificationType, @NonNull Instant createdAt, long notificationId) {
        this.id = id;
        this.userId = userId;
        this.notificationType = notificationType;
        this.createdAt = createdAt;
        this.notificationId = notificationId;
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
    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(@NonNull NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    @NonNull
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Instant createdAt) {
        this.createdAt = createdAt;
    }

    public long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }
}
