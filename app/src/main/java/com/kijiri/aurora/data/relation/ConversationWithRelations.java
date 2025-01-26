package com.kijiri.aurora.data.relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.Conversation;
import com.kijiri.aurora.data.entity.ConversationParticipant;
import com.kijiri.aurora.data.entity.Message;
import com.kijiri.aurora.data.entity.User;

import java.util.List;

public class ConversationWithRelations {
    @Embedded
    private Conversation conversation;

    @Relation(
            entity = User.class,
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(
                    value = ConversationParticipant.class,
                    parentColumn = "conversation_id",
                    entityColumn = "user_id"
            )
    )
    public List<User> users;

    @Relation(
            parentColumn = "id",
            entityColumn = "conversation_id"
    )
    public List<Message> messages;
}
