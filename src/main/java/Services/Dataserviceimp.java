package Services;

import Services.Dataservice;
import Dtos.Empserlaizer;
import entities.Employees;
import entities.Projects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Dataserviceimp implements Dataservice {

    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.baeldung.movie_catalog");
        return emf.createEntityManager();
    }
    public List<Empserlaizer> queryForEmployees(){
        EntityManager em = getEntityManager();
        List<Empserlaizer> employeesList = em.createQuery("select new Dtos.Empserlaizer(e)  from employees e ")
                .getResultList();

         return employeesList;
    }
    public List<Empserlaizer> queryemployeeofproject(String prjname){
        EntityManager em = getEntityManager();
        List<Empserlaizer> employeesList = em.createQuery(" select new Dtos.Empserlaizer(e)   from employees e join e.enrolledprojects p  join projects pr on p.ID = pr.ID where pr.name = ?1 ")
                .setParameter(1 , prjname).getResultList();
        return employeesList;
    };
    public boolean saveemployetoproject (long employeeid , long prjId){
        EntityManager em = getEntityManager();
        Projects prj = new Projects();
        Employees employee = (Employees) em.createQuery("select e  from employees e where e.id = ?1 ").setParameter(1 , employeeid)
                .getSingleResult();
        Projects project = (Projects) em.createQuery("select p  from projects p where p.ID = ?1 ").setParameter(1 , prjId).getSingleResult();
        em.getTransaction().begin();
        employee.getEnrolledprojects().add(project);
        em.persist(employee);
         try {
             em.getTransaction().commit();
             return true;
         }catch (Exception e){
             e.printStackTrace();
         }
         return false ;
    };
}
