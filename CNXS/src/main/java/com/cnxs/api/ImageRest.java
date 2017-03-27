package com.cnxs.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = { "Image/v1" })
public class ImageRest {
    
    private static String UPLOAD_FILE_PATH = System.getenv("CNXS_FILE_UPLOAD_PATH");
    
    private static List<String> VALID_FILE_TYPES = new ArrayList<String>();
    
    private static String FILE_URL_PREFIX = "http://101.37.39.51:8011/";
    
    static{
        VALID_FILE_TYPES.add("JPEG");
        VALID_FILE_TYPES.add("JPG");
        VALID_FILE_TYPES.add("PNG");
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()) {
            return new ResponseEntity<String>("File is empty!", HttpStatus.BAD_REQUEST);
        }
        
        try {
            
            String fileType = FilenameUtils.getExtension(file.getOriginalFilename());
            if(VALID_FILE_TYPES.contains(fileType.toUpperCase())) {
                
                byte[] bytes = file.getBytes();
                Date date = new Date();
                String fileName = date.getTime() + "."+fileType;
                Path path = Paths.get(UPLOAD_FILE_PATH + fileName);
                Files.write(path, bytes);
                return new ResponseEntity<String>(FILE_URL_PREFIX + fileName, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("File type invalid!", HttpStatus.BAD_REQUEST);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Error Occor when upload file!", HttpStatus.BAD_REQUEST);
        }
    }
}
