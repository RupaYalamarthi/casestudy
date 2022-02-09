package perscolas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscolas.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
//This restricts the controller Admin only, this can be done at the class level or at the method level
@PreAuthorize("hasAuthority('ADMIN')")
//ADMIN comes from database user role table

public class AdminController {
    public static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')") //Now it is used in UserController
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/home");

        return response;
    }
}
