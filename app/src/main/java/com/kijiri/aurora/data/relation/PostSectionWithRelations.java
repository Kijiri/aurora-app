package com.kijiri.aurora.data.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.kijiri.aurora.data.entity.PostContent;
import com.kijiri.aurora.data.entity.PostMedia;
import com.kijiri.aurora.data.entity.PostSection;

import java.util.List;

public class PostSectionWithRelations {
   
    @Embedded
    PostSection postSection;

    @Relation(
            parentColumn = "id",
            entityColumn = "post_section_id"
    )
    public List<PostContent> contentList;

    @Relation(
            parentColumn = "id",
            entityColumn = "post_section_id"
    )
    public List<PostMedia> postMediaList;
}
