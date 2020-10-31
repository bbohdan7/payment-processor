package ua.gov.bank.services.rest;

import ua.gov.bank.model.Payment;
import ua.gov.bank.services.PaymentService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentsAPI {

    @Inject
    private PaymentService service;

    @GET
    public List<Payment> all() {
        return service.all();
    }

    @POST
    public Response create(Payment payment) {
        service.create(payment);
        return Response.status(Response.Status.CREATED).build();
    }
}
