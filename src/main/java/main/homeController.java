package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reposotories.Movierepo;
import reposotories.GnereRepo;
import reposotories.userRepo;
import services.Movieservice;

@RestController
public class homeController {
@Autowired
userRepo UserRepo;
@Autowired
Movierepo movierepo;
@Autowired
GnereRepo gnereRepo;
@Autowired
Movieservice movieservice;
    @RequestMapping(value = "/hi" , method = RequestMethod.GET)
 public boolean sayhi() throws JsonProcessingException {

        return true;
        }

    }


