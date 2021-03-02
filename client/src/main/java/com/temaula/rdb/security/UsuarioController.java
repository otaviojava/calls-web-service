package com.temaula.rdb.security;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("usuarios")
@RolesAllowed({"user", "admin"})
public class UsuarioController {


    @GET
    @Path("/me")
    public String me(@Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        return principal.getName();
    }
}
