package com.sduonline.sdubaike.service.impl;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.cache.ResultCache;
import com.sduonline.sdubaike.dao.*;
import com.sduonline.sdubaike.entity.domain.Entry;
import com.sduonline.sdubaike.entity.domain.EntryContent;
import com.sduonline.sdubaike.entity.domain.EntryContentSource;
import com.sduonline.sdubaike.entity.domain.EntryEditor;
import com.sduonline.sdubaike.entity.vo.EntryContentVO;
import com.sduonline.sdubaike.entity.vo.EntryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sduonline.sdubaike.service.EntryService;

import java.util.ArrayList;
import java.util.List;

/**
 * 词条操作逻辑
 */
@Service("entryService")
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntryDao entryDao;

    @Autowired
    EntryFileDao entryFileDao;

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

    public Result newEntry(Entry entry) {
        entry.setPopularity(0);
        int entryNumber = entryDao.insert(entry);
        if (entryNumber != 0) return ResultCache.getDataOk(entry.getEntryId());
        else return ResultCache.getDataFailure("fail to create entry");
    }

    @Override
    public Result getEntryByEntryId(int entryId) {
        Entry entry = entryDao.selectById(entryId);
        entryDao.addPopularity(entryId);
        EntryVO entryVO = new EntryVO(entry.getEntryId(),entry.getEntryName(),
                entry.getEntryCreatorId(),entry.getEntryCreatorName(),entry.getPopularity());

        List<EntryEditor> entryEditors = new ArrayList<EntryEditor>();
        List<EntryContent> entryContents = entryContentDao.selectByEntryId(entryId);
        List<EntryContentVO> entryContentVOS = new ArrayList<EntryContentVO>();

        for (EntryContent entryContent : entryContents){
            EntryEditor entryEditor = new EntryEditor(entryContent.getEntryContenterId(),entryContent.getEntryContenterName());
            entryEditors.add(entryEditor);
            EntryContentVO entryContentVO = new EntryContentVO(entryContent.getEntryConcentId(),
                    entryContent.getEntryId(),
                    entryContent.getEntryContentTime(),
                    entryContent.getSummary(),
                    entryContent.getPicture(),
                    entryContent.getEditReason(),
                    entryContent.getState(),
                    entryContent.getEntryContenterId(),
                    entryContent.getEntryContenterName());
            entryContentVO.setEntryConcentBasicInfo(entryContentBasicInfoDao.selectByContentId(entryContent.getEntryConcentId()));
            entryContentVO.setEntryContentPoint(entryContentPointDao.selectByContentId(entryContent.getEntryConcentId()));
            entryContentVO.setEntryContentSource(entryContentSourceDao.selectByContentId(entryContent.getEntryConcentId()));
            entryContentVO.setEntryContentLabel(entryContentLabelDao.selectByContentId(entryContent.getEntryConcentId()));
            entryContentVOS.add(entryContentVO);
        }

        entryVO.setEntryContent(entryContentVOS);
        entryVO.setEntryEditor(entryEditors);
        entryVO.setEntryFile(entryFileDao.selectByEntryId(entry.getEntryId()));
        if (entry!=null) return ResultCache.getDataOk(entryVO);
        else return ResultCache.getDataFailure("fail to get");
    }

    @Override
    public Result getEntryByEntryName(String entryName) {
        List<Entry> entries = entryDao.selectByEntryName(entryName);
        List<EntryVO> entryVOS = new ArrayList<EntryVO>();
        for (Entry entry : entries) {
            EntryVO entryVO = new EntryVO(entry.getEntryId(), entry.getEntryName(),
                    entry.getEntryCreatorId(), entry.getEntryCreatorName(), entry.getPopularity());

            List<EntryEditor> entryEditors = new ArrayList<EntryEditor>();
            List<EntryContent> entryContents = entryContentDao.selectByEntryId(entry.getEntryId());
            List<EntryContentVO> entryContentVOS = new ArrayList<EntryContentVO>();

            for (EntryContent entryContent : entryContents) {
                EntryEditor entryEditor = new EntryEditor(entryContent.getEntryContenterId(), entryContent.getEntryContenterName());
                entryEditors.add(entryEditor);
                EntryContentVO entryContentVO = new EntryContentVO(entryContent.getEntryConcentId(),
                        entryContent.getEntryId(),
                        entryContent.getEntryContentTime(),
                        entryContent.getSummary(),
                        entryContent.getPicture(),
                        entryContent.getEditReason(),
                        entryContent.getState(),
                        entryContent.getEntryContenterId(),
                        entryContent.getEntryContenterName());
                entryContentVO.setEntryConcentBasicInfo(entryContentBasicInfoDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentPoint(entryContentPointDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentSource(entryContentSourceDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentLabel(entryContentLabelDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVOS.add(entryContentVO);
            }
                entryVO.setEntryContent(entryContentVOS);
                entryVO.setEntryEditor(entryEditors);
                entryVO.setEntryFile(entryFileDao.selectByEntryId(entry.getEntryId()));

                entryVOS.add(entryVO);
        }
        if (entryVOS != null) return ResultCache.getDataOk(entryVOS);
        else return ResultCache.getDataFailure("fail to get");
    }

    @Override
    public Result getEntryByLabelName(String labelName){
        List<Integer> entriyIds = entryContentLabelDao.selectByLabel(labelName);
        List<EntryVO> entryVOS = new ArrayList<EntryVO>();
        for (int entryId : entriyIds) {
            Entry entry = entryDao.selectById(entryId);
            EntryVO entryVO = new EntryVO(entry.getEntryId(), entry.getEntryName(),
                    entry.getEntryCreatorId(), entry.getEntryCreatorName(), entry.getPopularity());

            List<EntryEditor> entryEditors = new ArrayList<EntryEditor>();
            List<EntryContent> entryContents = entryContentDao.selectByEntryId(entry.getEntryId());
            List<EntryContentVO> entryContentVOS = new ArrayList<EntryContentVO>();

            for (EntryContent entryContent : entryContents) {
                EntryEditor entryEditor = new EntryEditor(entryContent.getEntryContenterId(), entryContent.getEntryContenterName());
                entryEditors.add(entryEditor);
                EntryContentVO entryContentVO = new EntryContentVO(entryContent.getEntryConcentId(),
                        entryContent.getEntryId(),
                        entryContent.getEntryContentTime(),
                        entryContent.getSummary(),
                        entryContent.getPicture(),
                        entryContent.getEditReason(),
                        entryContent.getState(),
                        entryContent.getEntryContenterId(),
                        entryContent.getEntryContenterName());
                entryContentVO.setEntryConcentBasicInfo(entryContentBasicInfoDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentPoint(entryContentPointDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentSource(entryContentSourceDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentLabel(entryContentLabelDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVOS.add(entryContentVO);
            }

            entryVO.setEntryContent(entryContentVOS);
            entryVO.setEntryEditor(entryEditors);
            entryVO.setEntryFile(entryFileDao.selectByEntryId(entry.getEntryId()));
            entryVOS.add(entryVO);
        }
        if (entryVOS != null) return ResultCache.getDataOk(entryVOS);
        else return ResultCache.getDataFailure("fail to get");
    }

    @Override
    public Result getEntryByPopularity() {
        List<Entry> entries = entryDao.selectByPopularity();
        List<EntryVO> entryVOS = new ArrayList<EntryVO>();
        for (Entry entry : entries) {
            EntryVO entryVO = new EntryVO(entry.getEntryId(), entry.getEntryName(),
                    entry.getEntryCreatorId(), entry.getEntryCreatorName(), entry.getPopularity());

            List<EntryEditor> entryEditors = new ArrayList<EntryEditor>();
            List<EntryContent> entryContents = entryContentDao.selectByEntryId(entry.getEntryId());
            List<EntryContentVO> entryContentVOS = new ArrayList<EntryContentVO>();

            for (EntryContent entryContent : entryContents) {
                EntryEditor entryEditor = new EntryEditor(entryContent.getEntryContenterId(), entryContent.getEntryContenterName());
                entryEditors.add(entryEditor);
                EntryContentVO entryContentVO = new EntryContentVO(entryContent.getEntryConcentId(),
                        entryContent.getEntryId(),
                        entryContent.getEntryContentTime(),
                        entryContent.getSummary(),
                        entryContent.getPicture(),
                        entryContent.getEditReason(),
                        entryContent.getState(),
                        entryContent.getEntryContenterId(),
                        entryContent.getEntryContenterName());
                entryContentVO.setEntryConcentBasicInfo(entryContentBasicInfoDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentPoint(entryContentPointDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentSource(entryContentSourceDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVO.setEntryContentLabel(entryContentLabelDao.selectByContentId(entryContent.getEntryConcentId()));
                entryContentVOS.add(entryContentVO);
            }
                entryVO.setEntryContent(entryContentVOS);
                entryVO.setEntryEditor(entryEditors);
                entryVO.setEntryFile(entryFileDao.selectByEntryId(entry.getEntryId()));
                entryVOS.add(entryVO);
        }
        if (entryVOS != null) return ResultCache.getDataOk(entryVOS);
        else return ResultCache.getDataFailure("fail to get");
    }
}