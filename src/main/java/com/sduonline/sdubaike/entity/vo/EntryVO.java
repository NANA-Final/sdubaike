package com.sduonline.sdubaike.entity.vo;

import com.sduonline.sdubaike.entity.domain.EntryEditor;
import com.sduonline.sdubaike.entity.domain.EntryFile;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
@Data
public class EntryVO {

    public EntryVO(Integer entryId, String entryName, Integer entryCreatorId, String entryCreatorName, Integer popularity) {
        this.entryId = entryId;
        this.entryName = entryName;
        this.entryCreatorId = entryCreatorId;
        this.entryCreatorName = entryCreatorName;
        this.popularity = popularity;
    }

    private Integer entryId;
    private String entryName;
    private Integer entryCreatorId;
    private String entryCreatorName;
    private Integer popularity;
    private List<EntryContentVO> entryContent;
    private List<EntryFile> entryFile;
    private List<EntryEditor> entryEditor;
}