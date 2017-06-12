package com.sduonline.sdubaike.entity.domain;

import lombok.Data;

/**
 * Created by Administrator on 2017/5/12.
 */
@Data
public class EntryFile {
    private Integer entryFileId;
    private Integer entryId;
    private String filename;
    private String fileUrl;
    private Integer state;
}
