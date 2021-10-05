package xom.test;
import org.apache.commons.codec.EncoderException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class App 
{
    public static void main( String[] args ) throws EncoderException{
        List<employee> employees = Arrays.asList(
                new employee("SE","AMOOR", "012821105452"),
                new employee("ST","AMR", "01282545252"),
                new employee("SE","AMOORaaa", "01282425452")
        );
       HashMap <String,Integer> titles = new HashMap<>();
            employees.stream().forEach(employee -> {
                int employecount = 1;
                if(!titles.containsKey(employee.getTitle())){
                    titles.put(employee.getTitle(),employecount);

                }
                else {
                    int prev = titles.get(employee.getTitle());
                    titles.put(employee.getTitle(), prev +employecount);
                }
            });
            for (String Title :titles.keySet()){
                if(titles.get(Title) == 1)
                System.out.println("Special Title: " + Title + ":" +titles.get(Title));
                else
                    System.out.println("Title : " + Title + ":" + titles.get(Title));
                employees.stream().filter(employee -> employee.getTitle().equals(Title)).forEach(employee -> {
                    System.out.println("name : " + employee.getName());
                    System.out.println("mobile :" + employee.getMobile());
                });
            }
            ;
        }
    }



