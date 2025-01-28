package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(
        indices = {
                @Index(value = {"last_name", "first_name"}),
                @Index(value = {"first_name"}),
                @Index(value = {"user_name"})
        }
)
public class User {
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "first_name")
    @NonNull
    private String firstName;

    @ColumnInfo(name = "last_name")
    @NonNull
    private String lastName;

    @ColumnInfo(name = "user_name")
    @NonNull
    private String userName;

    private Integer age;

    private String bio;

    @ColumnInfo(name = "avatar_url")
    private String avatarUrl;

    @ColumnInfo(name = "created_at")
    @NonNull
    private Instant createdAt;

    public User(long id,
                @NonNull String firstName,
                @NonNull String lastName,
                @NonNull String userName,
                Integer age, String bio,
                String avatarUrl,
                @NonNull Instant createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.age = age;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
    }
    
}
