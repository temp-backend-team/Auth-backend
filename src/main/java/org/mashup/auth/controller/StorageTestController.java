package org.mashup.auth.controller;

import org.mashup.auth.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StorageTestController {

    private S3Service s3Service;

    @Autowired
    public StorageTestController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @RequestMapping(value = "/spring-cloud/storage/{fileName}",
            consumes = "multipart/form-data",
            method = RequestMethod.POST)
    public String uploadFile(@PathVariable(name = "fileName")String fileName,
                           @RequestParam(name = "file")MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return "file is empty";
        }
        //파일 업로드
        return s3Service.uploadFile(multipartFile, fileName);
    }

    @RequestMapping(value = "/spring-cloud/storage/{fileName}", method = RequestMethod.DELETE)
    public void deleteFile(@PathVariable(name = "fileName")String fileName) {
        //파일 삭제
        s3Service.deleteFileFromS3Bucket(fileName);
    }
}
