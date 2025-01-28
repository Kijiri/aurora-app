package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Tag {
    
    @PrimaryKey
    private long id;
    
    @NonNull
    private String name;

    public Tag(@NonNull String name, long id) {
        this.name = name;
        this.id = id;
    }
}
