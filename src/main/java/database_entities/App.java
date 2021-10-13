package database_entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        getEntityManager();
        queryForEmployees();
        queryemployeeofproject();
        saveemployetoproject();
    }

    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.baeldung.movie_catalog");
        return emf.createEntityManager();
    }

    public static void queryForEmployees() {
        EntityManager em = getEntityManager();
        List<Employees> employeesList = em.createQuery("select e  from employees e  ")
                .getResultList();
       employeesList.forEach(employee ->{
           System.out.println((employee.getRole().getName()));
       });

        }

    public static void queryemployeeofproject(){
        EntityManager em = getEntityManager();
        List<Employees> employeesList = em.createQuery("select e  from employees e join e.enrolledprojects p  join projects pr on p.ID = pr.ID where pr.name = ?1 ")
                .setParameter(1 , "namaa").getResultList();
        employeesList.forEach(employee ->{
            System.out.println((employee));
        });

    }
    public static void saveemployetoproject() {
        EntityManager em = getEntityManager();
        Projects prj = new Projects();
        Employees employee = (Employees) em.createQuery("select e  from employees e where e.id = ?1 ").setParameter(1 , 1L)
                .getSingleResult();
        Projects project = (Projects) em.createQuery("select p  from projects p where p.ID = ?1 ").setParameter(1 , 1L).getSingleResult();
          em.getTransaction().begin();
          employee.getEnrolledprojects().add(project);
        em.persist(employee);
        em.getTransaction().commit();
    }
    }





