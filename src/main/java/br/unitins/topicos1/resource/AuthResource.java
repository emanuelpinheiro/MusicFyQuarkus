package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.AuthUsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.HashService;
import br.unitins.topicos1.service.HashServiceImpl;
import br.unitins.topicos1.service.JwtService;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    HashService hashService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JwtService jwtService;

    private static final Logger LOG = Logger.getLogger(AuthResource.class);

        @POST
    public Response login(AuthUsuarioDTO authDTO) {
        LOG.infof("Iniciando a autenticacao do %s", authDTO.login());

        String hash = hashService.getHashSenha(authDTO.senha());
        LOG.info("Hash da senha gerado.");


        UsuarioResponseDTO usuario = null;
        if (authDTO.perfil() == 1){
            LOG.info("Perfil de administrador");
            usuario = usuarioService.findByLoginAndSenha(authDTO.login(), hash);
        }
        else if (authDTO.perfil() == 2) {
            LOG.info("Perfil de cliente");
            usuario = usuarioService.findByLoginAndSenha(authDTO.login(), hash);
        } else {
            return Response.status(Status.NOT_FOUND)
                .entity("Username ou senha inválido").build();
        }
        return Response.ok(usuario)
                .header("Authorization", jwtService.generateJwt(usuario))
                .build();

    }

    public static void main(String[] args) {
        HashService h = new HashServiceImpl();
        String hash = h.getHashSenha("123");
        System.out.println(hash);
    }

    // @POST
    // public Response login(@Valid LoginDTO dto) {
    //     LOG.infof("Iniciando a autenticacao do %s", dto.login());

    //     String hashSenha = hashService.getHashSenha(dto.senha());

    //     LOG.info("Hash da senha gerado.");

    //     LOG.debug(hashSenha);

    //     UsuarioResponseDTO result = service.findByLoginAndSenha(dto.login(), hashSenha);

    //     if (result != null)
    //         LOG.info("Login e senha corretos.");
    //     else
    //         LOG.info("Login e senha incorretos.");
        
    //     String token = jwtService.generateJwt(result);

    //     LOG.info("Finalizando o processo de login.");

    //     return Response.ok().header("Authorization", token).build();
    // }
}
