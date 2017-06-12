package com.sduonline.sdubaike.service.impl;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.cache.ResultCache;
import com.sduonline.sdubaike.dao.*;
import com.sduonline.sdubaike.entity.domain.*;
import com.sduonline.sdubaike.entity.vo.EntryContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sduonline.sdubaike.service.EntryContentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 词条内容操作逻辑
 */
@Service("entryContentService")
public class EntryContentServiceImpl implements EntryContentService {

    @Autowired
    EntryContentDao entryContentDao;
    @Autowired
    EntryContentBasicInfoDao entryContentBasicInfoDao;
    @Autowired
    EntryContentPointDao entryContentPointDao;
    @Autowired
    EntryContentSourceDao entryContentSourceDao;
    @Autowired
    EntryContentLabelDao entryContentLabelDao;

    public Result newEntryContent(EntryContentVO entryContentVO) {
        EntryContent entryContent = new EntryContent(entryContentVO.getEntryConcentId(),
                entryContentVO.getEntryId(),
                entryContentVO.getEntryContentTime(),
                entryContentVO.getSummary(),
                entryContentVO.getPicture(),
                entryContentVO.getEditReason(),
                entryContentVO.getState(),
                entryContentVO.getEntryContenterId(),
                entryContentVO.getEntryContenterName());
        int entryContentNumber = entryContentDao.insert(entryContent);
        for (EntryContentBasicInfo entryContentBasicInfo : entryContentVO.getEntryConcentBasicInfo()){
            entryContentBasicInfo.setEntryContentId(entryContent.getEntryConcentId());
            entryContentBasicInfoDao.insert(entryContentBasicInfo);
        }
        for (EntryContentPoint entryContentPoint : entryContentVO.getEntryContentPoint()){
            entryContentPoint.setEntryContentId(entryContent.getEntryConcentId());
            entryContentPointDao.insert(entryContentPoint);
        }
        for (EntryContentSource entryContentSource : entryContentVO.getEntryContentSource()){
            entryContentSource.setEntryContentId(entryContent.getEntryConcentId());
            entryContentSourceDao.insert(entryContentSource);
        }
        for (EntryContentLabel entryContentLabel : entryContentVO.getEntryContentLabel()){
            entryContentLabel.setEntryContentId(entryContent.getEntryConcentId());
            entryContentLabelDao.insert(entryContentLabel);
        }
        if (entryContentNumber != 0) return ResultCache.getDataOk(entryContent.getEntryConcentId());
        else return ResultCache.getDataFailure("新建词条内容失败");
    }

}