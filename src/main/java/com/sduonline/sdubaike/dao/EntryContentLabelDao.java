package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.EntryContentLabel;
import com.sduonline.sdubaike.entity.domain.EntryContentSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryContentLabelDao {

    int insert(EntryContentLabel entryContentLabel);
    List<EntryContentLabel> selectByContentId(int entryContentId);
    List<Integer> selectByLabel(String label);
}