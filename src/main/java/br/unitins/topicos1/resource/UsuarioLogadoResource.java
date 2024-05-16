package br.unitins.topicos1.resource;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import java.io.IOException;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.dto.AtualizarEmailDTO;
import br.unitins.topicos1.dto.AtualizarNomeDTO;
import br.unitins.topicos1.dto.AtualizarSenhaDTO;
import br.unitins.topicos1.dto.AtualizarTelefoneDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.dto.CadastroUsuarioDTO;
import br.unitins.topicos1.dto.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.form.UsuarioImageForm;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.UsuarioRepository;
import br.unitins.topicos1.service.PedidoService;
import br.unitins.topicos1.service.UsuarioFileService;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;


@Path("/usuariologado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;

    @Inject
    UsuarioFileService fileService;

    @Inject
    PedidoService pedidoService;

    @Inject
    UsuarioRepository usuarioRepository;
    
    
    private static final Logger LOG = Logger.getLogger(UsuarioLogadoResource.class);
    @GET
    @Path("/meusdados")
    @RolesAllowed({ "User", "Admin" })
    public Response getUsuario() {

        String login = jwt.getSubject();


        return Response.ok(usuarioService.findByLogin(login)).build();
    }

    @POST
    @Path("/cadastro")
    @RolesAllowed("Admin")
    public Response cadastrarUsuario(@Valid CadastroUsuarioDTO dto) {
        LOG.info("Iniciando a inserção de usuario");

        if (usuarioRepository.findByLogin(dto.login()) != null) {
            LOG.info("Usuario não inserido, login já existente");
        } else
            LOG.info("Usuario inserido");


        CadastroUsuarioResponseDTO retorno = usuarioService.cadastrarUsuario(dto);

        LOG.infof("Terminando a inserção do usuario", dto.nome());
        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/senha")
    @RolesAllowed({ "User", "Admin" })
    public Response updateSenha(@Valid AtualizarSenhaDTO dto){
        LOG.info("Iniciando  o Update de senha");

        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateSenha(dto, login);
        


        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/nome")
    @RolesAllowed({ "User", "Admin" })
    public Response updateNome(@Valid AtualizarNomeDTO dto){
        LOG.info("Iniciando a o Update de nome");
        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateNome(dto, login);
        
      
        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/email")
    @RolesAllowed({ "User", "Admin" })
    public Response updateEmail(@Valid AtualizarEmailDTO dto){
        LOG.info("Iniciando a o Update de email");
        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateEmail(dto, login);
        LOG.info("Encerrando o update de email");        
        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/telefone")
    @RolesAllowed({ "User", "Admin" })
    public Response updateTelefone(@Valid AtualizarTelefoneDTO dto){
        LOG.info("Iniciando a o Update de telefone");
        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateTelefone(dto, login);

        return Response.status(201).entity(retorno).build();
    }

//     @GET
//     @RolesAllowed({"USER", "ADMIN"})
//     public Response getUsuario(){

//        String login  = jwt.getSubject();

//        return Response.ok(service.findByLogin(login)).build();

//     }
//     //alteração de senha
//     @PATCH
//     @Path("/senha")
//     @RolesAllowed({ "USER", "ADMIN" })
//     public Response updateSenha(UpdateSenhaDTO dto) {

//         String login = jwt.getSubject();

//         Usuario usuario = service.findByLogin(login);

//         try {

//             service.updateSenha(dto, usuario.getId());
//             Result result = new Result("200", "Senha atualizada com sucesso.");
//             LOG.info("Senha atualizada com sucesso.");

//             return Response.status(Status.OK).entity(result).build();

//         } catch (NotAuthorizedException e) {

//             LOG.error("Erro ao atualizar a senha do usuário.", e);
//             return Response
//                     .status(Status.FORBIDDEN).entity(e.getChallenges()).build();
//         }
//     }

//     @GET
//     @Path("/pedidos-usuario")
//     @RolesAllowed({"ADMIN", "USER"})
//     public Response pedidoUsuario(@QueryParam("idUsuario") Long idUsuario) {
//         LOG.infof("Buscando compras");
//         Result result = null;

//     try {
//         List<PedidoResponseDTO> response = pedidoService.findByAll(idUsuario);
//         LOG.info("Pesquisa realizada com sucesso.");
//         return Response.ok(response).build();
//     } catch (ConstraintViolationException e) {
//         LOG.error("Erro ao buscar compras.");
//         LOG.debug(e.getMessage());
//         result = new Result(e.getConstraintViolations());
//     } catch (Exception e) {
//         LOG.fatal("Erro sem identificacao: " + e.getMessage());
//         result = new Result("404", "Não identificado", false);
//     }

//     return Response.status(Status.NOT_FOUND).entity(result).build();
// }

//     @PATCH
//     @Path("/upload/imagem")
//     /* @RolesAllowed({ "USER", "ADMIN" }) */
//     @Consumes(MediaType.MULTIPART_FORM_DATA)
//     public Response salvarImagem(@MultipartForm UsuarioImageForm form){
        
//         try {
//             String nomeImagem = "";
//             nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
//         } catch (IOException e) {
//             e.printStackTrace();
//             Result result = new Result("409", e.getMessage());
//             return Response.status(Status.CONFLICT).entity(result).build();
//         }
                
//         Result result = new Result("200", "Imagem salva com sucesso");
//         return Response.status(Status.OK).entity(result).build();
//     }

//     @GET
//     @Path("/download/imagem/{nomeImagem}")
//     /* @RolesAllowed({ "USER", "ADMIN" }) */
//     @Produces(MediaType.APPLICATION_OCTET_STREAM)
//     public Response download(@PathParam("nomeImagem") String nomeImagem) {
//         ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
//         response.header("Content-Disposition", "attachment;filename="+nomeImagem);
//         return response.build();
//     }

}
