package perscolas.database.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscolas.database.entity.User;
import perscolas.database.entity.UserRole;

import java.util.List;


public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

}
