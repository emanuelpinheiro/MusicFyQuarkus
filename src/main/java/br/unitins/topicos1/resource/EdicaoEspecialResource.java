package br.unitins.topicos1.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.EdicaoEspecialDTO;
import br.unitins.topicos1.service.EdicaoEspecialService;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("edicaoespecial")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EdicaoEspecialResource {
    
    @Inject
    EdicaoEspecialService service;

    private static final Logger LOG = Logger.getLogger(EdicaoEspecialResource.class);

    @GET
    /* @RolesAllowed({"ADMIN"}) */
    public Response findByAll(){
        LOG.info("Listando todas as edições especiais.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    /* @RolesAllowed({"ADMIN"}) */
    public Response findById(@PathParam("id") Long id){
        LOG.infof("Listando a edição especial do id %s", id);
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/descricao/{descricao}")
    /* @RolesAllowed({"ADMIN"}) */
    public Response findByDescricao(@PathParam("descricao") String descricao){
        LOG.infof("Listando a edição especial da descrição %s", descricao);
        return Response.ok(service.findByDescricao(descricao)).build();
    }

    @GET
    @Path("/conteudoadicional/{conteudoadicional}")
    /* @RolesAllowed({"ADMIN"}) */
    public Response findByConteudoAdicional(@PathParam("conteudoadicional") String conteudoAdicional){
        LOG.infof("Listando a edição especial do conteúdo adicional %s", conteudoAdicional);
        return Response.ok(service.findByConteudoAdicional(conteudoAdicional)).build();
    }

    @GET
    @Path("/precoextra/{precoextra}")
    /* @RolesAllowed({"ADMIN"}) */
    public Response findByPrecoExtra(@PathParam("precoextra") Float precoExtra){
        LOG.infof("Listando a edição especial do preço extra %s", precoExtra);
        return Response.ok(service.findByPrecoExtra(precoExtra)).build();
    }

    @POST
    /* @RolesAllowed({"ADMIN"}) */
    /* @Transactional */
    public Response insert(EdicaoEspecialDTO dto){
        LOG.info("Inserindo uma nova edição especial.");
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    }

    @PUT
    @Path("/{id}")
    /* @RolesAllowed({"ADMIN"}) */
    /* @Transactional */
    public Response update(@PathParam("id") Long id, EdicaoEspecialDTO dto){
        LOG.infof("Atualizando a edição especial do id %s", id);
        return Response.ok(service.update(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
   /*  @RolesAllowed({"ADMIN"}) */
    /* @Transactional */
    public Response delete(@PathParam("id") Long id){
        LOG.infof("Deletando a edição especial do id %s", id);
        service.delete(id);
        return Response.noContent().build();
    }
}
