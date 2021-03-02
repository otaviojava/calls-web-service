package my.compary.service;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Path("/calls")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CallController {

    private final CallService service;

    private final Validator validator;

    @Inject
    public CallController(CallService service, Validator validator) {
        this.service = service;
        this.validator = validator;
    }

    @GET
    public List<CallDTO> findAll(@BeanParam CallFilter query) {
        return service.query(query);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }

    @POST
    public Response create(CallsDTO dtos) {
        Set<ConstraintViolation<CallsDTO>> validations = validator.validate(dtos);
        if (validations.isEmpty()) {
            return Response.ok(service.save(dtos)).build();
        } else {
            return Response.status(BAD_REQUEST)
                    .entity(new Result(validations)).build();
        }
    }
}
