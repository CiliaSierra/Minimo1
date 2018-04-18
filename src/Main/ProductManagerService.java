
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


//DIFERENCIA ENTRE POST Y GET
//POST, cuando haces algo (modifico algo del programa) y GET cuando solo das algo (pides)

@Path("pedidos") //Como llamar path == URL
//@Singleton
public class ProductManagerService {
    ProductManagerImplemets pm = ProductManagerImplemets.getInstance();
        /**
        * Method handling HTTP GET requests. The returned object will be sent
        * to the client as "text/plain" media type.
        * @return String that will be returned as a text/plain response.
        */
//Test de los productos
    //Comprovacion de funcionamiento
    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    //Registro de Usuario
    @Path("crearUsuario/{usuario}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
     public Usuario crearUsuario(@PathParam("usuario") Usuario usuario) {
        return pm.getInstance().login(usuario);
    }
    //Listado de producto por precio
    @Path("listaProductosPrecio")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listaProductoPrecio(){
        return pm.getListaDeProductosPorPrecio();
    }
    //Realizar Pedido
    @POST
    @Path("RealizarPedido/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean realizarPedido(@PathParam("ID") int userID, List<Producto> productos){//como recoge los productos
        return pm.getInstance().hacerPedido(userID,productos);
    }
    //Servir Pedido
    @Path("/ServirPedido")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public boolean servirPedido(){
        return pm.servirPedido();
    }
    //Listado de pedidos de un usuarios
    @Path("listaPedidosUsuario/{ID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> listaPedidosUsuario(@PathParam("ID") int userID){
        return pm.getPedidosUsuario(userID);
    }
    //Lista de producto por venta
    @Path("listaProductoVentas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listaProductoVentas(){
        return pm.getProductoVentas();
    }
}