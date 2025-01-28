package com.kijiri.aurora.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.kijiri.aurora.data.enums.ConversationRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(
        primaryKeys = {"user_id", "conversation_id"},
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "user_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Conversation.class,
                        parentColumns = "id",
                        childColumns = "conversation_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index(value = {"user_id", "conversation_id"}, unique = true)
        }
)
public class ConversationParticipant {
    @ColumnInfo(name = "user_id")
    private long userId;
    @ColumnInfo(name = "conversation_id")
    private long conversationId;
    @ColumnInfo(name = "conversation_role")
    private ConversationRole conversationRole;
    
    @ColumnInfo(name = "is_read")
    private boolean isRead;

    public ConversationParticipant(long userId, long conversationId, ConversationRole conversationRole, boolean isRead) {
        this.userId = userId;
        this.conversationId = conversationId;
        this.conversationRole = conversationRole;
        this.isRead = isRead;
    }
}
