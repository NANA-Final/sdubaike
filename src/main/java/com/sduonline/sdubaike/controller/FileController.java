package com.sduonline.sdubaike.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/5.
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @RequestMapping(value = "/update_picture",method = RequestMethod.POST)
    public String updateFile(@RequestParam(value = "picture", required = false) MultipartFile file) throws IOException {
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
        return path+fileName;
    }

}