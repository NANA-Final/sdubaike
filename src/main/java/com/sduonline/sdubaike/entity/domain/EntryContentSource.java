package com.sduonline.sdubaike.entity.domain;

import lombok.Data;

/**
 * Created by Administrator on 2017/6/2.
 */
@Data
public class EntryContentSource {
    private Integer entryContentSourceId;
    private Integer entryContentId;
    private String sourceName;
    private String url;
}