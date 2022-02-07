package perscolas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscolas.form.LoginFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AnOtherLoginController {

    //use setAttribute to set an error message in the session in the formSubmit2 method
    //getattribute to get the error message from the session in the login method
    //response(mode). addObject to make the error message available to the JSP
    //after the login.jsp to show the error message from the model using ${} notation.

    private static String SESSION_KEY = "usernameSessionKey";
    @RequestMapping(value = "/anotherlogin", method = RequestMethod.GET)
    public ModelAndView anotherlogin(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        String username = (String) session.getAttribute("SESSION_KEY");
        if (StringUtils.equals(username, "tom")) {
            response.setViewName("redirect:/anothersuccess");

        } else {
            response.setViewName("anotherlogin/anotherlogin");
        }

        return response;
    }


    @RequestMapping(value = "/loginFormSubmit2", method = RequestMethod.GET)
    public ModelAndView loginSubmit(LoginFormBean form, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = form.getUsernameFromForm();
        String password = form.getPasswordFromForm();
        if (StringUtils.equals(username, "tom") && StringUtils.equals(password, "jerry")) {
            session.setAttribute("SESSION_KEY", username);
            response.setViewName("redirect:/anothersuccess");
        } else {
            session.setAttribute("username", null);
            response.setViewName("redirect:/anotherlogin");
        }

        return response;
    }

    @RequestMapping(value = "/anothersuccess", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute("SESSION_KEY");
        if (StringUtils.equals(username, "tom")) {
            response.addObject("loggedInUser", username);
            response.setViewName("/anotherlogin/anothersuccess");
        } else {
            response.setViewName("redirect:/anotherlogin");
        }

        return response;
    }

    @RequestMapping(value = "/anotherlogout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) throws Exception {
        session.invalidate();
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/anotherlogin");
        return response;
    }

}
