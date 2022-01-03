package ua.gov.bank.services.rest;

import ua.gov.bank.model.Employee;
import ua.gov.bank.services.EmployeeService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeAPI {

    @Inject
    private EmployeeService svc;

    @GET
    public List<Employee> all() {
        return svc.all();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Integer id) {
        Employee result = svc.find(id);
        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND.getStatusCode(), "Couldn't find requested employee.").build();
        }
        return Response.ok(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee){
        svc.create(employee);
        return Response.ok("Successfully created!").build();
    }

    @PUT
    @Path("{id}")
    public Response updateEmployee(@PathParam("id") Integer id, Employee employee){
        if(svc.find(id) != null) {
            employee.setId(id);
            svc.update(employee);
            return Response.ok("Updated").build();
        }

        return Response.ok("Unable to update employee as it wasn't found.").build();
    }


}
