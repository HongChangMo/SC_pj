package com.sc.sc_pj.service.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/file")
@RestController
public class CommonFileController {

    @Value("${custom.path.upload-path}")
    private String uploadPath;

    // ckeditor 임시 파일 저장
    @PostMapping("/upload/image")
    public ModelAndView UploadImage(MultipartRequest request) throws Exception{

        ModelAndView mv = new ModelAndView("jsonView");

        String realPath = uploadPath + "/temp/";
        File dir = new File(realPath);
        
        // 폴더 없으면 생성
        if( !dir.exists() ) {
            dir.mkdir();
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        String originFileName = null;
        String fileExt = null;
        String newFileName = null;
        String savePath = null;
        String uploadUrl = null;


        List<MultipartFile> files = request.getFiles("upload");

        for( MultipartFile file : files ) {
            if( files.get(0).getSize() > 0 ) {
                // 원본 파일명
                originFileName = file.getOriginalFilename();
                // 파일 확장자
                fileExt = originFileName.substring(originFileName.indexOf("."));
                // 저장 파일명
                newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileExt;
                log.debug("newFileName : " + newFileName);

                savePath = realPath + newFileName;

                // ckeditor 임시 파일 저장
                uploadUrl = "/upload/temp/" + newFileName;

                File uploadFile = new File(savePath);

                file.transferTo(uploadFile);

                resultMap.put("uploaded", true);
                resultMap.put("fileName", originFileName);
                resultMap.put("url", uploadUrl);
            }
        }

        mv.addObject("uploaded", true);
        mv.addObject("resultMap" + resultMap);

        return mv;
    }
}
