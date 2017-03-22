package com.cnxs.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "Simple/v1" })
public class SimpleRest {
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getSample() {
        return new ResponseEntity<String>("sample", HttpStatus.OK);
    }
}
