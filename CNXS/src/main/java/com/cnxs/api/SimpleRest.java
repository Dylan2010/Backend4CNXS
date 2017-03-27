package com.cnxs.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
    
}
