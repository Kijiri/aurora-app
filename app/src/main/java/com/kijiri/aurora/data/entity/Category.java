package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
