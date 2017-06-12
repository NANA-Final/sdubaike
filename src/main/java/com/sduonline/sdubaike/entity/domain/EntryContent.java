package com.sduonline.sdubaike.entity.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
@Data
public class EntryContent {
    public EntryContent() {
    }

    public EntryContent(Integer entryConcentId, Integer entryId, String entryContentTime, String summary, String picture, String editReason, Integer state, Integer entryContenterId, String entryContenterName) {
        this.entryConcentId = entryConcentId;
        this.entryId = entryId;
        this.entryContentTime = entryContentTime;
        this.summary = summary;
        this.picture = picture;
        this.editReason = editReason;
        this.state = state;
        this.entryContenterId = entryContenterId;
        this.entryContenterName = entryContenterName;
    }

    private Integer entryConcentId;
    private Integer entryId;
    private String entryContentTime;
    private String summary;
    private String picture;
    private String editReason;
    private Integer state;
    private Integer entryContenterId;
    private String entryContenterName;

}