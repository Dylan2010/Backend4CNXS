package com.cnxs.api;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = { "Simple/v1" })
public class SimpleRest {
   
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getSample() {
        return new ResponseEntity<String>(System.getenv("MYSQL_ROOT_PASSWORD"), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> testphoto() throws IOException {
    	ClassPathResource resource = new ClassPathResource("2.jpeg");
    	Path path = Paths.get(resource.getURI());
       
        byte[] data = Files.readAllBytes(path);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(data.length);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        
        return new ResponseEntity<byte[]>(data,headers, HttpStatus.CREATED);
    }
    
    @PostMapping("/upload")
    public ResponseEntity<Boolean> uploadFile(@RequestParam("file") MultipartFile file) {
    	if(file.isEmpty()) {
    		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
    	}
    	
    	try {
    		
            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
            
            return new ResponseEntity<Boolean>(true, HttpStatus.BAD_REQUEST);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
