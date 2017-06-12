package com.sduonline.sdubaike.entity.domain;

import lombok.Data;

/**
 * Created by Administrator on 2017/6/2.
 */
@Data
public class EntryEditor {

    public EntryEditor(Integer entrtEditorId, String entryEditorName) {
        this.entrtEditorId = entrtEditorId;
        this.entryEditorName = entryEditorName;
    }

    private Integer entrtEditorId;
    private String entryEditorName;
}
