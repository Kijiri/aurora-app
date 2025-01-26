package com.kijiri.aurora.data.util;

import androidx.room.TypeConverter;

import com.kijiri.aurora.data.enums.ConversationRole;
import com.kijiri.aurora.data.enums.MediaType;
import com.kijiri.aurora.data.enums.NotificationType;
import com.kijiri.aurora.data.enums.PublishStatus;

import java.time.Instant;

public class Converters {
    
    @TypeConverter
    public static Long fromInstant(Instant instant) {
        return instant.toEpochMilli();
    }
    
    @TypeConverter
    public static Instant toInstant(Long millis) {
        return Instant.ofEpochMilli(millis);
    }
    
    @TypeConverter
    public static String fromConversationRole(ConversationRole role) {
        return role.name();
    }

    @TypeConverter
    public static ConversationRole toConversationRole(String role) {
        return ConversationRole.valueOf(role);
    }

    @TypeConverter
    public static String fromPublishStatus(PublishStatus publishStatus) {
        return publishStatus.name();
    }

    @TypeConverter
    public static PublishStatus toPublishStatus(String status) {
        return PublishStatus.valueOf(status);
    }

    @TypeConverter
    public static String fromNotificationType(NotificationType notificationType) {
        return notificationType.name();
    }

    @TypeConverter
    public static NotificationType toNotificationType(String status) {
        return NotificationType.valueOf(status);
    }

    @TypeConverter
    public static String fromMediaType(MediaType mediaType) {
        return mediaType.name();
    }

    @TypeConverter
    public static MediaType toMediaType(String type) {
        return MediaType.valueOf(type);
    }
    
}
