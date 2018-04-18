import java.util.List;
//Interfaz, llamada a las funciones principales del programa
public interface ProductManager {
    //llamamos a las 5 funciones
    Usuario login(Usuario u);

    //Listado de productos ordenado
    List<Producto>  getListaDeProductosPorPrecio();

    //Realizar un pedido (de diferentes productos y diferentes cantidades) por parte de un usuario identificado
    boolean  hacerPedido (int userId, List<Producto> products);

    //Servir pedido. Los servicios se realizan en orden de llegadas.
    boolean servirPedido();

    //Listado de pedidos de un usuario que ya hayan sido realizados
    List<Pedido> getPedidosUsuario(int userId);

    //Listado de productos ordenado (descendiente) por número de ventas
    List<Producto> getProductoVentas();
}
