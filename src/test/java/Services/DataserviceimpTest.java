package Services;

import Dtos.Empserlaizer;
import entities.Employees;
import entities.Projects;
import entities.role;
import Dtos.paginationDto;
import javafx.scene.control.Pagination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import javax.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class DataserviceimpTest {

    @Mock
    private EntityManager Entitymanager ;


    @InjectMocks
    private Dataserviceimp Dataserviceimp = new Dataserviceimp()  ;
    private Empserlaizer employee = new Empserlaizer("test user","test@test.net","012552","4554533",23,"software engineer");
    Employees getemployee(){
        Employees employee = new Employees();
        employee.setId(5);
        employee.setName("Amr");
        employee.setAge(22);
        employee.setEmail("amoor@gmail.com");
        employee.setPhone("01258666");
        employee.setEnrolledprojects(new ArrayList<Projects>());
        return employee ;
    }
    Projects getproject(){

        Projects  p = new Projects();

        p.setID(1);
        p.setName("amr");
        return p;
    }

    @BeforeEach
    public void Mocksinit() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void queryForEmployees() {

        List<Empserlaizer> employees = new ArrayList<>();
        List<Empserlaizer> actualEmployees = new ArrayList<>();
        employees.add(employee);
        Query query = mock(Query.class);
        when(Entitymanager.createQuery(Mockito.anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(employees);
        actualEmployees = Dataserviceimp.queryForEmployees();
        assertArrayEquals(employees.toArray(),actualEmployees.toArray());



    }

    @Test
    void queryemployeeofproject() {


        List<Empserlaizer> employees = new ArrayList<>();
        List<Empserlaizer> actualEmployees = new ArrayList<>();
        employees.add(employee);
        Query query = mock(Query.class);
        when(Entitymanager.createQuery(" select new Dtos.Empserlaizer(e)   from employees e join e.enrolledprojects p  join projects pr on p.ID = pr.ID where pr.name = ?1 ")).thenReturn(query);
        when(query.setParameter(Mockito.anyInt(),Mockito.anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(employees);
        actualEmployees = Dataserviceimp.queryemployeeofproject(Mockito.anyString());
        assertArrayEquals(employees.toArray(),actualEmployees.toArray());


    }

    @Test
    void saveemployetoproject() {

        Employees  dummyEmployee = getemployee();
        Projects dummyproject =  getproject();
        Query Empquery = mock(Query.class);
        Query pquery = mock(Query.class);
        when(Entitymanager.createQuery("select e  from employees e where e.id = ?1 ")).thenReturn(Empquery);
        when(Empquery.setParameter(Mockito.anyInt(),Mockito.anyString())).thenReturn(Empquery);
        when(Empquery.getSingleResult()).thenReturn(dummyEmployee);
        when(Entitymanager.createQuery("select p  from projects p where p.ID = ?1 ")).thenReturn(pquery);
        when(pquery.setParameter(Mockito.anyInt(),Mockito.anyString())).thenReturn(pquery);
        when(pquery.getSingleResult()).thenReturn(dummyproject);

        EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        when(Entitymanager.getTransaction()).thenReturn(transaction);

        assertEquals(Dataserviceimp.saveemployetoproject(dummyEmployee.getId() ,dummyproject.getID()),true);
        assertEquals(dummyEmployee.getEnrolledprojects().add(dummyproject),true);

    }





    @Test
    void pagingEmployees() {

        paginationDto p = new paginationDto();
        p.setPageIndex(1);
        p.setPageSize(2);
        Query query = mock(Query.class);
        List<Empserlaizer> employees = new ArrayList<>();
        List<Empserlaizer> actualEmployees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee);
        when(Entitymanager.createQuery("select new Dtos.Empserlaizer(e)  from employees e ")).thenReturn(query);
        when(query.setFirstResult(1)).thenReturn(query);
        when(query.setMaxResults(2)).thenReturn(query);
        when(query.getResultList()).thenReturn(employees);
        actualEmployees = Dataserviceimp.pagingEmployees(p);
        assertArrayEquals(employees.toArray(),actualEmployees.toArray());


    }
}