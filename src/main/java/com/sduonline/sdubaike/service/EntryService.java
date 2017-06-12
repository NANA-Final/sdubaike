package com.sduonline.sdubaike.service;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.entity.domain.Entry;

/**
 * 词条操作逻辑接口
 */
public interface EntryService {

    Result newEntry(Entry entry);
    Result getEntryByEntryId(int entryId);
    Result getEntryByEntryName(String entryName);
    Result getEntryByLabelName(String labelName);
    Result getEntryByPopularity();
}