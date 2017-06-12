package com.sduonline.sdubaike.service;


import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.entity.domain.EntryContent;
import com.sduonline.sdubaike.entity.domain.EntryContentBasicInfo;
import com.sduonline.sdubaike.entity.domain.EntryContentPoint;
import com.sduonline.sdubaike.entity.vo.EntryContentVO;

import java.util.Map;

public interface EntryContentService {


    Result newEntryContent(EntryContentVO entryContentVO);

}