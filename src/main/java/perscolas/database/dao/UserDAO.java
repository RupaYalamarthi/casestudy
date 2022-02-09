package perscolas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscolas.database.entity.User;
import perscolas.database.entity.UserRole;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    //@Query("select u from user u where u.firstName = :firstname)
    //replaces spring framework does this query for us
    public List<User> findByFirstName(@Param("firstName") String firstName);


    public List<User> findByLastName(@Param("lastName") String lastName);

    public List<User> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);
    public List<User> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);

    public List<User> findAll();
    @Query("select u from User u where u.username = :username")
    public User findByUsername(@Param("username") String uname);

    @Query(value="SELECT u.* FROM users u WHERE u.first_name like %:firstName%", nativeQuery = true)
    public List<User> findByFirstNameLike(@Param("firstName") String firstName);

    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(@Param("userId") Integer userId);
}
