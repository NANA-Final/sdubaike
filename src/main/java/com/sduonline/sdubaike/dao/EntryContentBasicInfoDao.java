package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.Entry;
import com.sduonline.sdubaike.entity.domain.EntryContentBasicInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryContentBasicInfoDao {

    int insert(EntryContentBasicInfo entryContentBasicInfo);
    List<EntryContentBasicInfo> selectByContentId(Integer entryConcentId);

}