package Services;

import Dtos.Empserlaizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DataserviceimpTest {

    @Mock
    private EntityManager Entitymanager ;
    @InjectMocks
    private Dataserviceimp Dataserviceimp  ;


    private Empserlaizer employee = new Empserlaizer("test user","test@test.net","012552","4554533",23,"software engineer");


    @Test
    void queryForEmployees() {
        MockitoAnnotations.openMocks(this);
        List<Empserlaizer> employees = new ArrayList<>();
        List<Empserlaizer> actualEmployees = new ArrayList<>();
        employees.add(employee);
        Query query = mock(Query.class);
        when(Entitymanager.createQuery("select new Dtos.Empserlaizer(e)  from employees e")).thenReturn(query);
        //doReturn(query).when(Entitymanager).createQuery("select new Dtos.Empserlaizer(e)  from employees e");
        when(query.getResultList()).thenReturn(employees);
        actualEmployees = Dataserviceimp.queryForEmployees();
        //actualEmployees = Entitymanager.createQuery("select new Dtos.Empserlaizer(e)  from employees e").getResultList();
        assertArrayEquals(employees.toArray(),actualEmployees.toArray());

    }

    @Test
    void queryemployeeofproject() {
        List<Empserlaizer> employees = new ArrayList<>();
        List<Empserlaizer> actualEmployees = new ArrayList<>();
        employees.add(employee);
        Query query = mock(Query.class);
        when(Entitymanager.createQuery(" select new Dtos.Empserlaizer(e)   from employees e join e.enrolledprojects p  join projects pr on p.ID = pr.ID where pr.name = ?1 ").setParameter(1,"namaa")).thenReturn(query);
        when(query.getResultList()).thenReturn(employees);


    }

    @Test
    void saveemployetoproject() {
    }
}