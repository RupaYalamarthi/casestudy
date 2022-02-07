package perscolas.validation;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import perscolas.database.dao.UserDAO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {
    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);
    @Autowired
   private UserDAO userdao;


    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        boolean passes = !StringUtils.equals(value, "a@b.com");
        return (passes);
    }
}
