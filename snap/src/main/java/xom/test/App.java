package xom.test;
import com.sun.javaws.jnl.MatcherReturnCode;
import org.apache.commons.codec.EncoderException;

import javax.validation.constraints.Null;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;


public class App 
{
    public static void main( String[] args ) throws EncoderException {
        List<String>lastvisted = new ArrayList<>();
        List<String>Disabilties  = new ArrayList<>();
        List<String>medical  = new ArrayList<>();
        Disabilties.add("parallism");
        medical.add("paracetmol");
        lastvisted.add("egypt");
        lastvisted.add("united-stated");
        flowmanager fm = new flowmanager();
        List<traveller> travellers = Arrays.asList(
                new traveller(2344,"amooor",lastvisted,Boolean.FALSE,Boolean.FALSE,"-ve",null,Boolean.FALSE) ,
              new traveller(2344,"amooor",lastvisted,Boolean.FALSE,Boolean.FALSE,"-ve",null,Boolean.TRUE,Disabilties , medical)
        );


         fm.manage_flow(travellers);


    }


    }



