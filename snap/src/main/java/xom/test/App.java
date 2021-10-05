package xom.test;
import org.apache.commons.codec.EncoderException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class App 
{
    public static void main( String[] args ) throws EncoderException{

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        String Date = "20/10/2020";
        Date obj_date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy") ;
        try {
            obj_date = formatter.parse(Date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Appointement appointement = new Appointement("amr",-25,"09","amrgmail.com","amoor",obj_date);
        Set<ConstraintViolation<Appointement>> violations = validator.validate(appointement);
        for (ConstraintViolation<Appointement> violation : violations) {
          System.out.println(violation.getMessage());
        }
    }


}
