package com.sduonline.sdubaike.controller;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.entity.domain.EntryContent;
import com.sduonline.sdubaike.entity.domain.EntryContentBasicInfo;
import com.sduonline.sdubaike.entity.domain.EntryContentPoint;
import com.sduonline.sdubaike.entity.vo.EntryContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sduonline.sdubaike.service.EntryContentService;

import java.util.Map;

@RestController
@RequestMapping(value = "/entryContent")
public class EntryContentController {

    @Autowired
    EntryContentService entryContentService;

    @RequestMapping(value = "/new_entryContent", method = RequestMethod.POST)
    public Result newEntryContent(@RequestBody EntryContentVO entryContentVO) {
        System.out.println(entryContentVO);
        return entryContentService.newEntryContent(entryContentVO);
    }

}