package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.CDDTO;
import br.unitins.topicos1.service.CDService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/cd")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CDResource {

    @Inject
    CDService service;

    private static final Logger LOG = Logger.getLogger(CDResource.class);

    @GET
    public Response findByAll(){
        LOG.info("Listando todos os CDs.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        LOG.infof("Listando o CD do id %s", id);
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        LOG.infof("Listando o CD do nome %s", nome);
        return Response.ok(service.findByNome(nome)).build();
    }

    @POST
    @Transactional
    public Response insert(@Valid CDDTO dto){
        LOG.infof("Inserindo um novo CD: %s", dto.nome());
        Result result = null;
        try {
            LOG.infof("Inserido o novo CD");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            LOG.infof("Erro ao inserir o CD.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), "404", false);
        }
        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid CDDTO dto){
        LOG.infof("Atualizando o CD do id %s", id);
        Result result = null;
        try {
            LOG.infof("Atualizado o CD do id %s", id);
            return Response.ok(service.update(id, dto)).build();
        } catch (ConstraintViolationException e) {
            LOG.infof("Erro ao atualizar o CD.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), "404", false);
        }
        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        LOG.infof("Deletando CD %s", id);
        service.delete(id);
        LOG.info("CD deletado.");
        return Response.noContent().build();
    }
}
