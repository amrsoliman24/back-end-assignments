package Services;

import Dtos.Empserlaizer;
import entities.Employees;

import java.util.List;

public interface Dataservice  {
    public List<Empserlaizer> queryForEmployees();
    public List<Empserlaizer> queryemployeeofproject(String prjname);
    public boolean saveemployetoproject (long employeeid , long prjId);
}
