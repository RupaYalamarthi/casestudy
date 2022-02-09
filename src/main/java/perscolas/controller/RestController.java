package perscolas.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import perscolas.database.dao.UserDAO;
import perscolas.database.entity.User;

import java.util.List;

@Controller

@RequestMapping("/rest")

public class RestController {
    @Autowired
    private UserDAO userDao;

    //in a rest controller a get method is always used for reads
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable Integer id) {
        User user = userDao.findById(id);
        return user;
    }

    @GetMapping(value ="/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getList(@RequestParam(required = false) String firstName) {
        List<User> users = userDao.findByFirstNameLike(firstName);
        return users;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Long> delete(@PathVariable Integer id) {
        User user = userDao.findById(id);

        if (id != null && user != null) {
//            JSONObject jo = new JSONObject();
//            jo.put("status","success");
//            jo.put("response_code","200");
            userDao.delete(user);
            return new ResponseEntity<>(id.longValue(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
