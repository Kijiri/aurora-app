package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.Instant;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @NonNull
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Instant createdAt) {
        this.createdAt = createdAt;
    }
}
