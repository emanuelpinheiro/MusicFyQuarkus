package br.unitins.topicos1.resource;

import java.util.List;

import org.jboss.logging.Logger;
import br.unitins.topicos1.model.Faixa;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.FaixaResponseDTO;
import br.unitins.topicos1.dto.FaixaDTO;
import br.unitins.topicos1.service.FaixaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/faixas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FaixaResource {

    @Inject
    FaixaService service;
    
    private static final Logger LOG = Logger.getLogger(FaixaResource.class);


    @POST
    //@Transactional
    public Response insert(@Valid FaixaDTO dto){
        LOG.infof("Inserindo uma nova faixa: %s", dto.nome());
        Result result = null;
        try {
            LOG.infof("Inserido a nova faixa");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();

        } catch (ConstraintViolationException e) {
            LOG.infof("Erro ao inserir o faixa.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), "404", false);
        }
        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @PUT
    //@Transactional
    @Path("/{id}")   
    public Response update(FaixaDTO dto, @PathParam("id") Long id){
        Result result = null;
        try{
            service.update(dto, id);
            LOG.infof("Atualizando a faixa: %s", dto.nome());
            return Response.status(Status.OK).build();
        } catch (ConstraintViolationException e) {
            LOG.infof("Erro ao atualizar a faixa.");
            result = new Result(e.getConstraintViolations());
            return Response.status(Status.BAD_REQUEST).entity(result).build();
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), "404", false);  
        }
         return Response.status(Status.NOT_FOUND).entity(result).build();
    }


    @DELETE
    /* @Transactional */
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException{
        try{
            service.delete(id);
            LOG.infof("Deletado o faixa: %d", id);
            return Response.status(Status.OK).build();
        } catch (IllegalArgumentException e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            return Response.status(Status.NOT_FOUND).build();
        }
        
    }


    @GET
    public Response findAll(){
        LOG.infof("Buscando todos os faixas");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    public FaixaResponseDTO findById(@PathParam("id") Long id) throws NotFoundException{
        LOG.infof("Buscando faixa por id: %d", id);
        return service.findById(id);
    }

    @GET
    @Path("/search/{nome}")
    public List<FaixaResponseDTO> findByName(@PathParam("nome") String nome)
       {
        LOG.infof("Buscando faixa por nome: %s", nome);
        return service.findByName(nome);
    }
    
}
