package ua.gov.bank.services;

import ua.gov.bank.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService extends Service<User> {

    @PersistenceContext(unitName = "PaymentsPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public UserService() {
        super(User.class);
    }

    @GET
    public List<User> all() {
        return super.all();
    }

    @POST
    public Response create(User user) {
        super.create(user);
        return Response.ok().entity("User has been created!").build();
    }

    @GET
    @Path("{id}")
    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

}
