package ua.gov.bank.services.rest;

import ua.gov.bank.model.Employee;
import ua.gov.bank.services.EmployeeService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
}
