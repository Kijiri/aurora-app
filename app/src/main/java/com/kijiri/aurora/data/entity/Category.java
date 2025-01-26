package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        indices = {
                @Index(
                        value = {"name"},
                        unique = true
                )
        }
)
public class Category {
    
    @PrimaryKey
    private long id;
    
    @NonNull
    private String name;

    public Category(@NonNull String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
