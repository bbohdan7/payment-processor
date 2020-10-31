package ua.gov.bank.services.rest;

import ua.gov.bank.model.User;
import ua.gov.bank.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersAPI {

    @Inject
    private UserService service;

    @GET
    public List<User> all() {
        return service.all();
    }

    @GET
    @Path("{id}")
    public User find(@PathParam("id") Integer id) {
        return service.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        service.create(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Integer id, User user) {
        boolean userExist = service.find(id) != null;

        if (userExist) {
            user.setId(id);
            service.update(user);
            return Response.status(Response.Status.ACCEPTED).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        User usr = service.find(id);

        if (usr != null) {
            service.delete(usr);
            return Response.status(Response.Status.OK).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
