package com.sduonline.sdubaike.entity.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
@Data
public class Entry {
    private Integer entryId;
    private String entryName;
    private Integer entryCreatorId;
    private String entryCreatorName;
    private Integer popularity;
}