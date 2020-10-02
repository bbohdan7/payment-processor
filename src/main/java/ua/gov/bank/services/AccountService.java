package ua.gov.bank.services;

import ua.gov.bank.model.Account;
import ua.gov.bank.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class AccountService extends Service<Account> {

    @PersistenceContext(unitName = "PaymentsPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public AccountService() {
        super(Account.class);
    }

    @GET
    public List<Account> all() {
        return super.all();
    }

    @GET
    @Path("{id}")
    public Account find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @POST
    public Response createAcc(Account acc) {
        super.create(acc);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    public Response deleteAcc(Account acc){
        super.delete(acc);
        return Response.status(Response.Status.OK.getStatusCode(), "Successfully removed.").build();
    }

    @GET
    @Path("/user/{id}")
    public User user(@PathParam("id") Integer id) {
        Optional<User> usr = Optional.ofNullable(find(id).getUser());

        return usr.orElse(null);
    }

}
