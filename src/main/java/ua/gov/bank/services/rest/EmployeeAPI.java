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
}
