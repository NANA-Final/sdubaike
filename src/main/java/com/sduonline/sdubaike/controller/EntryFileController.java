package com.sduonline.sdubaike.controller;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.entity.domain.EntryFile;
import com.sduonline.sdubaike.service.EntryFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping(value = "/entryFile")
public class EntryFileController {

    @Autowired
    EntryFileService entryFileService;

    @RequestMapping(value = "/new_entryFile",method = RequestMethod.POST)
    public Result newEntryFile(EntryFile entryFile,MultipartFile file) throws IOException {
        return entryFileService.newEntryFile(entryFile,file);
    }

}