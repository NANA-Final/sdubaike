package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.Entry;
import com.sduonline.sdubaike.entity.domain.EntryContentSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对词条表的操作
 */
@Repository
public interface EntryContentSourceDao {

    int insert(EntryContentSource entryContentSource);
    List<EntryContentSource> selectByContentId(int entryContentId);
}