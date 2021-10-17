package Services;

import Dtos.Empserlaizer;
import entities.Employees;
import entities.Projects;
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
        Employees e = new Employees();
        e.setId(5);
        e.setName("Amr");
        e.setAge(22);
        e.setEmail("amoor@gmail.com");
        e.setPhone("01258666");

        return e ;

    }
    Projects getproject(){
        Projects p = new Projects();
        p.setID(2);
        p.setName("amr's project");
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

        Employees e = getemployee();
        Projects p =  getproject();
        Query query = mock(Query.class);
        when(Entitymanager.createQuery("select e  from employees e where e.id = ?1 ")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(e);
        when(Entitymanager.createQuery("select p  from projects p where p.ID = ?1 ")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(p);
        EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        when(Entitymanager.getTransaction()).thenReturn(transaction);
        doNothing().when(transaction).begin();
        assertEquals(e.getEnrolledprojects().add(Mockito.any()),true);


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