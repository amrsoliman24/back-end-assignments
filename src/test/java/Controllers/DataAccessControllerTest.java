package Controllers;

import Dtos.Empserlaizer;
import Services.Dataservice;
import Services.Dataserviceimp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class  DataAccessControllerTest {
    @Mock
    Dataservice DS ;
    @InjectMocks
    DataAccessController DAC = new DataAccessController()  ;
    private Empserlaizer employee = new Empserlaizer("test user","test@test.net","012552","4554533",23,"software engineer");

    @Test
    void queryformployees() {
        MockitoAnnotations.initMocks(this);
        List<Empserlaizer> employeeList = new ArrayList<>();
        employeeList.add(employee);
        when(DS.queryForEmployees()).thenReturn(employeeList);
        Response r = DAC.queryformployees();
        assertEquals(Response.Status.OK.getStatusCode() , r.getStatus());
    }
    @Test
    void queryforEmproject() {
        MockitoAnnotations.initMocks(this);
        List<Empserlaizer> employeeList = new ArrayList<>();
        employeeList.add(employee);
        when(DS.queryemployeeofproject("HRSD")).thenReturn(employeeList);
        Response r = DAC.queryforEmproject("HRSD");
        assertEquals(Response.Status.OK.getStatusCode() , r.getStatus());
        employeeList.remove(0);
        when(DS.queryemployeeofproject("anyproject")).thenReturn(employeeList);
        r = DAC.queryforEmproject("anyproject");
        assertEquals(Response.Status.NOT_FOUND.getStatusCode() , r.getStatus());
    }


    @Test
    void addEmptoproject() {

        MockitoAnnotations.initMocks(this);
        when(DS.saveemployetoproject(1L,1L)).thenReturn(false);
        Response r = DAC.addEmptoproject(1L,1L);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode() , r.getStatus());
        when(DS.saveemployetoproject(1L,2L)).thenReturn(true);
        r = DAC.addEmptoproject(1L,2L);
        assertEquals(Response.Status.OK.getStatusCode() , r.getStatus());



    }

    @Test
    void pagingemployees() {




    }
}