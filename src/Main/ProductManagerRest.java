import jdk.nashorn.internal.objects.annotations.Getter;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//DIFERENCIA ENTRE POST Y GET
//POST, cuando haces algo (modifico algo del programa) y GET cuando solo das algo (pides)

@Path("/pedidos") //Como lllamar path == URL
@Singleton
public class ProductManagerRest {
    ProductManagerImplemets pm = ProductManagerImplemets.getInstance();
    //Comprovacion de funcionamiento
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    //Registro de Usuario
    @POST
    @Path("/CrearUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario crearUsuario(Usuario usuario) {
        return pm.login(usuario);
    }

    //Listado de producto por precio
    @GET
    @Path("/listaProductosPrecio")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listaProductoPrecio(){
        return pm.getListaDeProductosPorPrecio();
    }
    //Realizar Pedido
    @POST
    @Path("/{ID}/RealizarPedido")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean realizarPedido(@PathParam("ID") int userID, List<Producto> productos){//como recoge los productos
        return pm.hacerPedido(userID,productos);
    }
    //Servir Pedido
    @GET
    @Path("/ServirPedido")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean servirPedido(){
        return pm.servirPedido();
    }
    //Listado de pedidos de un usuarios
    @GET
    @Path("/{ID}/listaPedidosUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> listaPedidosUsuario(@PathParam("ID") int userID){
        return pm.getPedidosUsuario(userID);
    }
    //Lista de producto por venta
    @GET
    @Path("/listaProductoVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listaProductoVentas(){
        return pm.getProductoVentas();
    }


}
