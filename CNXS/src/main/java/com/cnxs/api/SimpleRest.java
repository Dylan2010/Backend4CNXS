package com.cnxs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cnxs.dao.UserDao;

@RestController
@RequestMapping(value = { "Simple/v1" })
public class SimpleRest {
    
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getSample() {
        return new ResponseEntity<String>(System.getenv("MYSQL_ROOT_PASSWORD"), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/db",method = RequestMethod.GET)
    public ResponseEntity<String> getSampleFromDB() {
        return new ResponseEntity<String>(userDao.getUserById(1).getAccount(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/type/{type}/id/{id}",method = RequestMethod.GET)
    public ResponseEntity<String> getFrompath(@PathVariable String type,@PathVariable int id) {
        return new ResponseEntity<String>(type + id, HttpStatus.OK);
    }
}
