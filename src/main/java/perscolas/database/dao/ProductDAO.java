package perscolas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perscolas.database.entity.Product;
import perscolas.database.entity.User;

public interface ProductDAO extends JpaRepository<Product, Long> {

}
