package com.sduonline.sdubaike.dao;


import com.sduonline.sdubaike.entity.domain.EntryContentBasicInfo;
import com.sduonline.sdubaike.entity.domain.EntryContentPoint;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryContentPointDao {

    int insert(EntryContentPoint entryContentPoint);
    List<EntryContentPoint> selectByContentId(Integer entryConcentId);

}