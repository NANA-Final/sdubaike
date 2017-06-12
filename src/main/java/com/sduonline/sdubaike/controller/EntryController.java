package com.sduonline.sdubaike.controller;

import com.sduonline.sdubaike.base.Result;
import com.sduonline.sdubaike.cache.ResultCache;
import com.sduonline.sdubaike.entity.domain.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sduonline.sdubaike.service.EntryService;


/**
 * 词条请求控制
 */

@RestController
@RequestMapping(value = "/entry")
public class EntryController {

    @Autowired
    EntryService entryService;

    @RequestMapping(value = "/new_entry",method = RequestMethod.POST)
    public Result newEntry(Entry entry)
    {
        return entryService.newEntry(entry);
    }

    @RequestMapping(value = "/get_entry_by_entryId",method = RequestMethod.POST)
    public Result getEntryByEntryId(int entryId)
    {
        return entryService.getEntryByEntryId(entryId);
    }

    @RequestMapping(value = "/get_entry_by_entryName",method = RequestMethod.POST)
    public Result getEntryByEntryName(String entryName)
    {
        return entryService.getEntryByEntryName(entryName);
    }

    @RequestMapping(value = "/get_entry_by_labelName",method = RequestMethod.POST)
    public Result getEntryByLabelName(String labelName)
    {
        return entryService.getEntryByLabelName(labelName);
    }

    @RequestMapping(value = "/get_entry_by_popularity",method = RequestMethod.POST)
    public Result getEntryByPopularity()
    {
        return entryService.getEntryByPopularity();
    }
}