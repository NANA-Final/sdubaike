package com.sduonline.sdubaike.service.impl;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.cache.ResultCache;
import com.sduonline.sdubaike.dao.EntryFileDao;
import com.sduonline.sdubaike.entity.domain.EntryFile;
import com.sduonline.sdubaike.service.EntryFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Service("entryFileService")
public class EntryFileServiceImpl implements EntryFileService {

    @Autowired
    EntryFileDao entryFileDao;

    public Result newEntryFile(EntryFile entryFile,MultipartFile file) throws IOException {
        Random random = new Random();
        String path = "";
        String fileName = new Date().getTime()+""+ random.nextInt(100000000);
        File targetFile = new File(path, fileName);
        targetFile.createNewFile();
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        entryFile.setFileUrl(path+fileName);
        int entryFileNumber = entryFileDao.insert(entryFile);
        if (entryFileNumber != 0) return ResultCache.getDataOk(entryFile.getEntryFileId());
        else return ResultCache.getDataFailure("failed");
    }


}