package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kijiri.aurora.data.enums.MediaType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Media {
    @PrimaryKey
    private long id;
    
    @NonNull
    @ColumnInfo(name = "type")
    private MediaType mediaType;

    public Media(long id, @NonNull MediaType mediaType) {
        this.id = id;
        this.mediaType = mediaType;
    }
}
