package com.kijiri.aurora.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kijiri.aurora.data.enums.MediaType;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(@NonNull MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
