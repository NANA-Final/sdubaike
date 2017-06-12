package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.Entry;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对词条表的操作
 */
@Repository
public interface EntryDao {

    int insert(Entry entry);
    Entry selectById(int entryId);
    List<Entry> selectByEntryName(String entryName);
    List<Entry> selectByPopularity();
    void addPopularity(int entryId);
}