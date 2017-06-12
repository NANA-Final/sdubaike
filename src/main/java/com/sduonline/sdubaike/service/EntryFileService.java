package com.sduonline.sdubaike.service;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.cache.ResultCache;
import com.sduonline.sdubaike.entity.domain.EntryFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/1.
 */
public interface EntryFileService {
    Result newEntryFile(EntryFile entryFile,MultipartFile file) throws IOException;
}
