package com.sduonline.sdubaike.entity.domain;

import lombok.Data;

/**
 * Created by Administrator on 2017/5/5.
 */
@Data
public class EntryContentPoint {
    private Integer entryContentPointId;
    private Integer entryContentId;
    private String title;
    private String content;
    private String pointPicture;
}