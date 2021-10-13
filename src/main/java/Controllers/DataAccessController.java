package Controllers;

import Dtos.Empserlaizer;
import Services.Dataservice;
import Services.Dataserviceimp;
import entities.Employees;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/DataAccess")
public class DataAccessController {

    Dataservice ds = new Dataserviceimp();

    @GET @Path("empquery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response  queryformployees(){
        if (ds.queryForEmployees().size() == 0){
            return Response.status(Response.Status.NOT_FOUND).build();
       }
        return  Response.ok(ds.queryForEmployees()).build();
    }
    @GET @Path("emprojquery/{prjname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response queryforEmproject(@PathParam("prjname") String Prjname){

        if (ds.queryemployeeofproject(Prjname).size() == 0){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return  Response.ok(ds.queryemployeeofproject(Prjname)).build();
    }
    @PUT
    @Path("addemptoprj/{ employeeId}/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmptoproject(@PathParam("employeeId") Long EmpId, @PathParam("projectId") Long PrjId ){
        if (ds.saveemployetoproject(EmpId,PrjId)) {
            return Response.status(200, "ok").build() ;
        }
          return Response.status(400, "invalid information provided").build();


    }

}
