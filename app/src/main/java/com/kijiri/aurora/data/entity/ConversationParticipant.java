package com.kijiri.aurora.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.kijiri.aurora.data.enums.ConversationRole;

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

    public ConversationParticipant(long userId, long conversationId, ConversationRole conversationRole) {
        this.userId = userId;
        this.conversationId = conversationId;
        this.conversationRole = conversationRole;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getConversationId() {
        return conversationId;
    }

    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }

    public ConversationRole getConversationRole() {
        return conversationRole;
    }

    public void setConversationRole(ConversationRole conversationRole) {
        this.conversationRole = conversationRole;
    }
}
