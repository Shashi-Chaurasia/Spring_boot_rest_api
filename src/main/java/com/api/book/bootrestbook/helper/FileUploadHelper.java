package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // public final String UPLOAD_DIR = "D:\\Ecclipse-2021-12\\VsSpringBootProject\\Book\\bootrestbook\\src\\main\\resources\\static\\images";
    public final String UPLOAD_DIR = new ClassPathResource("static/images").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException{
        
    }
    public boolean uploadFile(MultipartFile multipartFile){
        boolean f = false;
        try {
            // InputStream is = multipartFile.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // // ---------Write-----------------
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile);
            // fos.write(data);
            // fos.flush();
            // fos.close();
            // f = true;


            Files.copy(multipartFile.getInputStream(), 
            Paths.get(UPLOAD_DIR, File.separator + multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            

            return true;

            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return f;
    }


}
