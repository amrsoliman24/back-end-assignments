package xom.test;

import java.util.ArrayList;
import java.util.List;

public class traveller {
    private long ID ;
    private String name ;
    private List<String> last_visited ;
    private Boolean hasfever ;
    private Boolean hascough ;
    private String  PCR_Status;
    private String Arrival_point;
    private Boolean has_special_conditons ;
    private List<String> disabilites =  new ArrayList<String>();
    private List<String> medicine_allergies =  new ArrayList<String>();

    public traveller (long Id , String name, List<String>  last_visited , Boolean hascough ,Boolean hasfever , String PCR_Status ,String Arrival_point, Boolean has_special_conditons  ) {
       this.ID = Id;
       this.name = name;
       this.last_visited = last_visited;
       this.hascough =  hascough ;
       this.hasfever =  hasfever ;
       this.PCR_Status = PCR_Status ;
       this.Arrival_point = Arrival_point ;
       this.has_special_conditons = has_special_conditons;
    }
    public traveller (long Id , String name, List<String>  last_visited , Boolean hascough ,Boolean hasfever , String PCR_Status ,String Arrival_point, Boolean has_special_conditons  ,List<String> disabilites , List<String> medicine_allergies ) {
        this.ID = Id;
        this.name = name;
        this.last_visited = last_visited;
        this.hascough =  hascough ;
        this.hasfever =  hasfever ;
        this.PCR_Status = PCR_Status ;
        this.Arrival_point = Arrival_point ;
        this.has_special_conditons = has_special_conditons;
        this.disabilites = disabilites;
        this.medicine_allergies = medicine_allergies;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPCR_Status() {
        return PCR_Status;
    }

    public void setPCR_Status(String PCR_Status) {
        this.PCR_Status = PCR_Status;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public List<String> getLast_visited() {
    return this.last_visited;
    }

    public void setLast_visited(List<String> last_visited) {
        this.last_visited = last_visited;
    }

    public Boolean getHascough() {
        return hascough;
    }

    public Boolean getHasfever() {
        return hasfever;
    }

    public void setHascough(Boolean hascough) {
        this.hascough = hascough;
    }

    public void setHasfever(Boolean hasfever) {
        this.hasfever = hasfever;
    }

    public Boolean getHas_special_conditons() {
        return has_special_conditons;
    }

    public List<String> getDisabilites() {
        return disabilites;
    }

    public List<String> getMedicine_allergies() {
        return medicine_allergies;
    }

    public String getArrival_point() {
        return Arrival_point;
    }

    public void setArrival_point(String arrival_point) {
        Arrival_point = arrival_point;
    }

    public void setDisabilites(List<String> disabilites) {
        this.disabilites = disabilites;
    }

    public void setHas_special_conditons(Boolean has_special_conditons) {
        this.has_special_conditons = has_special_conditons;
    }

    public void setMedicine_allergies(List<String> medicine_allergies) {
        this.medicine_allergies = medicine_allergies;
    }

}
