// package br.unitins.topicos1;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;

// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.ArtistaDTO;
// import br.unitins.topicos1.dto.PedidoDTO;
// import br.unitins.topicos1.service.ArtistaService;
// import br.unitins.topicos1.service.PedidoService;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;

// public class PedidoResourceTest {

//     @Inject
//     PedidoService pedidoService;

//     @Test
//     public void testFindAll() {
//         given()
//           .when().get("/pedidos")
//           .then()
//              .statusCode(200);
//     }

//     @Test
//     public void testInsert() {

//         PedidoDTO PedidoDTO = new PedidoDTO(null, null, null);

//         given()
//             .contentType(ContentType.JSON)
//             .body(ArtistaDTO)
//             .when().post("/artistas")
//             .then()
//                 .statusCode(201)
//                 .body("nome", is("nome1"), 
//                       "descricao", is("descricao1"));
//     }


    
// }
package br.unitins.topicos1;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import br.unitins.topicos1.service.PedidoService;
import jakarta.inject.Inject;

public class PedidoResourceTest {

    @Inject
    PedidoService pedidoService;

    @Test
    public void testFindAll() {
        given()
          .when().get("/pedidos")
          .then()
             .statusCode(200);
    }
}
