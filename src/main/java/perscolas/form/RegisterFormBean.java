package perscolas.form;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import perscolas.validation.EmailUnique;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegisterFormBean {

    public Integer id;
    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^.+@.+$", message="Please provide a valid E-mail format")
   // @EmailUnique(message = "Email must be Unique")
    public String email;

    @Length(min = 1, max = 50, message = "First Name must be between 1 and 5 character in length.")
    public String firstName;

    @NotEmpty(message = "Last Name is required")
    public String lastName;

    @Min(value=3, message = "Age must be at least 3.")
    @Max(value=10, message = "Age must be at most 10.")
    public Integer age;

    @NotEmpty(message = "Username is required")
    private String username;
    public String password;
    public String confirmPassword;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
