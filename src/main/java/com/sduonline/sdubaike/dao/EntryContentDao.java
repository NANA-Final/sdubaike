package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.EntryContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryContentDao {

    int insert(EntryContent entryContent);
    List<EntryContent> selectByEntryId(int entryId);

}