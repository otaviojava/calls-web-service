package my.compary.service;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/calls")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CallController {

    private final CallService service;

    @Inject
    public CallController(CallService service) {
        this.service = service;
    }

    @GET
    @Path("/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<CallDTO> findAll(@BeanParam CallFilter query) {
        return service.query(query);
    }
}
