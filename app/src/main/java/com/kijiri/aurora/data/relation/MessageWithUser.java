package com.kijiri.aurora.data.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.Message;
import com.kijiri.aurora.data.entity.User;

public class MessageWithUser {
    @Embedded
    public Message message;

    @Relation(
            parentColumn = "sender_id",
            entityColumn = "id"
    )
    public User sender;
}
