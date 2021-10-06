package xom.test;

import javax.management.timer.Timer;
import java.util.List;

public class flowmanager {
    public void manage_flow(List<traveller> travellers) {
        for (traveller t : travellers) {
            if (t.getArrival_point() == null) {
                t.setArrival_point("port officer");
                printofficerdata(t);
            }
        }

    }

    public void printofficerdata(traveller t) {
        System.out.println(t.getName() + "  has reached the port office");
        System.out.println("PCR Status is " + t.getPCR_Status());
        if (t.getHas_special_conditons() == Boolean.TRUE) {
            System.out.println("diasbilties :");
            t.getDisabilites().forEach(disabilty -> {
                System.out.println(disabilty);

            });

            t.setArrival_point("health officer");


        }
        go_to_health(t);

    }

    public void go_to_health(traveller t) {
        if (t.getHasfever() == Boolean.TRUE) {
            conduct_pcr(t);

        } else {
            System.out.println(t.getName() + "   has reached the health office");
            System.out.println("PCR Status is " + t.getPCR_Status());
            if (t.getHas_special_conditons() == Boolean.TRUE) {
                System.out.println("diasbilties :");
                t.getDisabilites().forEach(disabilty -> {
                    System.out.println(disabilty);



                });
                System.out.println("Medicine_allergies :");
                  t.getMedicine_allergies().forEach(medical -> {
                      System.out.println(medical);
                  });



            }
            System.out.println("last place visited ");
            t.getLast_visited().forEach(place ->{
                        System.out.println( place);
                    }
            );
            System.out.println("has fever  " + t.getHasfever());
            System.out.println("has cough   " + t.getHascough());
            t.setArrival_point("immigration officer");
            gotoimmigration(t);
        }
    }

    public void conduct_pcr(traveller t) {
        System.out.println(t.getName() + "has reached pcr conductor");
        System.out.println("has fever  " + t.getHasfever());
        System.out.println("has cough   " + t.getHascough());
        t.setArrival_point("immigration officer");
        gotoimmigration(t);

    }

    public void gotoimmigration(traveller t) {
        System.out.println(t.getName() + "has reached immigration-office");
        System.out.println("PCR Status is " + t.getPCR_Status());
        if (t.getHas_special_conditons() == Boolean.TRUE) {
            System.out.println("diasbilties :");
            t.getDisabilites().forEach(disabilty -> {
                System.out.println(disabilty);

            });



        }
        System.out.println("last place visited ");
        t.getLast_visited().forEach(place ->{
            System.out.println( place);
                }
        );

    }
}

