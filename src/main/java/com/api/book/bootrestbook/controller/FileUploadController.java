package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.helper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload_file")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
      try {

        if (file.isEmpty()) {
            System.out.println("In empty file condition");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("File not been selected");
            
        }
        
        if(!file.getContentType().equals("images/jpg")){
            System.out.println("In getcontent");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Only jpg file are allowed");
        }

        //--------add upload path here ----------------

        boolean f = fileUploadHelper.uploadFile(file);
        if (f) {
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/images/").path(file.getOriginalFilename()).toUriString());
        }
    
          
      } catch (Exception e) {
          e.printStackTrace();
      }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong please try again");
        
    }
    
}
