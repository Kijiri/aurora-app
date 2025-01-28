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
                        entity = Conversation.class,
                        parentColumns = "id",
                        childColumns = "conversation_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("conversation_id")
        }
)
public class Message {
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "conversation_id")
    private long conversationId;
    
    @ColumnInfo(name = "sender_id")
    private long senderId;
    
    private String text;
    
    @ColumnInfo(name = "created_at")
    private Instant createdAt;
    
    private boolean edited;

    public Message(long id, long conversationId, long senderId, String text, Instant createdAt, boolean edited) {
        this.id = id;
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.text = text;
        this.createdAt = createdAt;
        this.edited = edited;
    }
}
