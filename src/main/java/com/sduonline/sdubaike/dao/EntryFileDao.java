package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.EntryFile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryFileDao {

    int insert(EntryFile entryFile);
    List<EntryFile> selectByEntryId(Integer entryId);

}