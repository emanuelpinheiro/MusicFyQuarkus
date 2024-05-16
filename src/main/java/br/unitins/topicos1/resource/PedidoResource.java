package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.service.PedidoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

    
@Path("/pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService service;

    @Inject
    JsonWebToken jwt;
    
    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @POST
    @Path("/fazer-pedido")
    @RolesAllowed({ "User", "Admin" })
    public Response insert(@Valid PedidoDTO dto) {
        LOG.info("Iniciando inserção de Pedido");
        String login = jwt.getSubject();
        LOG.infof("usuario logado %s", login);
        PedidoResponseDTO retorno = service.insert(login,dto);
        LOG.info("Finalizando o processo de pedido.");
        return Response.status(201).entity(retorno).build();
    }



    @GET
    @Path("/buscar/meuspedidos")
    @RolesAllowed({ "User", "Admin" })
    public Response findByAll() {
        LOG.info("Iniciando busca de Pedidos");

        String login = jwt.getSubject();
        
        List<PedidoResponseDTO> pedidos = service.findByAll(login);
        return Response.ok(pedidos).build();
    }

    @GET
    @Path("buscar/pedido/{id}")
    @RolesAllowed({"Admin" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Iniciando busca do Pedido : %s", id);
        PedidoResponseDTO pedido = service.findById(id);
        if (pedido != null) {
            return Response.ok(pedido).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

//     private Result result;
     

//     @POST
//     @Path("/iniciar-pedido")
//    /*  @RolesAllowed({ "USER", "ADMIN" }) */
//     public Response insert(@Valid PedidoDTO dto){
//         LOG.infof("Inserindo um novo pedido: %s");
//         try {
//             String login = jwt.getSubject();
//             LOG.infof("Usuário logado: %s", login);
//             PedidoResponseDTO ip = service.insert(login, dto);
//             LOG.infof("Pedido inserido com sucesso: %s", ip);
//             return Response.status(Status.CREATED).entity(ip).build();

//         } catch (ConstraintViolationException e) {
//             LOG.infof("Erro ao inserir, campo nulo.");
//             LOG.debug(e.getMessage());
//             result = new Result(e.getConstraintViolations());
//         } catch (Exception e) {
//             LOG.fatal("Erro sem identificação: " + e.getMessage());
//             result = new Result(e.getMessage(), "404", false);
//         }
//         return Response.status(Status.NOT_FOUND).entity(result).build();
//     }

   

//     @GET
//     @Path("buscar/pedido/{id}")
//     /* @RolesAllowed({"ADMIN" }) */
//     public Response findById(@PathParam("id") Long id) {
//         LOG.infof("Iniciando busca do Pedido : %s", id);
//         PedidoResponseDTO pedido = service.findById(id);
//         if (pedido != null) {
//             return Response.ok(pedido).build();
//         } else {
//             return Response.status(Status.NOT_FOUND).build();
//         }
//     }

}
