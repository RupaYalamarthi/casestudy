package perscolas.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import perscolas.database.dao.UserDAO;
import perscolas.database.dao.UserRoleDAO;
import perscolas.database.entity.User;
import perscolas.form.RegisterFormBean;

import javax.validation.Valid;
import java.util.List;

@Controller

@RequestMapping("/rest")

public class RestController {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    // this method creates a new user
    @RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> get(@Valid RegisterFormBean form, BindingResult errors) {
        User user = new User();

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setUsername(form.getUsername());

        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        userDao.save(user);

        return new ResponseEntity<Long>(HttpStatus.OK);
    }

    // this method creates a new user
    @RequestMapping(value ="", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> put(@Valid RegisterFormBean form, BindingResult errors) {
        User user = userDao.findById(form.getId());

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setUsername(form.getUsername());

        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        userDao.save(user);

        return new ResponseEntity<Long>(HttpStatus.OK);
    }

}
