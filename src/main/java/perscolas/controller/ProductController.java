package perscolas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscolas.database.dao.ProductDAO;
import perscolas.database.entity.Product;
import perscolas.database.entity.User;

import java.util.List;

@Controller

public class ProductController {
    @Autowired
    private ProductDAO productDao;
    @RequestMapping(value = "products/productList", method = RequestMethod.GET)
    public ModelAndView productList(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/productList");
        List<Product> products = productDao.findAll();
        response.addObject("products", products);
        return response;
    }
}
