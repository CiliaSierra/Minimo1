
import java.util.*;
import java.util.logging.Logger;

public class ProductManagerImplemets implements ProductManager {
    //Implemetnacion de las 5 funciones como Singletone
    //Declaraciones
    private static ProductManagerImplemets instance = null;
    final static Logger logger = Logger.getLogger(String.valueOf(ProductManagerImplemets.class));

    private Queue<Pedido> pedidos; //lista de conciertos iniciales
    private List<Pedido> servirPedidios;

    //Singleton Pattern
    public static ProductManagerImplemets getInstance() {
        if (instance == null) instance = new ProductManagerImplemets();
        return instance;
    }
    //Constructores
    private ProductManagerImplemets(){
        this.pedidos = new ArrayDeque<>();
        this.servirPedidios = new ArrayList<>();
    }
    //Getters and Setters
    public Queue<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Pedido> getServirPedidios() {
        return servirPedidios;
    }

    //Funciones pricipales
    //Lista de productos oredenados por precio
    public List<Producto> getListaDeProductosPorPrecio() {
        logger.info("Productos servidos por coste");
        return ProductosPorCoste(getPedidosServidos());
    }
   //Hacer un pedido
    public boolean hacerPedido (int userId, List<Producto> producto) {
        logger.info("Hacer Pedido");
        this.pedidos.add(new Pedido(producto, userId, false));
        logger.info("Hecha ");
        return true;
    }
    //servir un pedido
    public boolean servirPedido() {
        logger.info("Servir Pedido");

        if(!pedidos.isEmpty()) { //si hay pedidos en la cola
            this.servirPedidios.add(this.pedidos.element()); //guardar en la lista de pedidos hechos
            this.pedidos.remove(); //eliminar de la cola
            logger.info("Pedido Servido");
            return true;
        }
        else {
            logger.warning("No hay Pedidos para servir");
            return false;
        }
    }
    //lista de pedidos hechos por un Usuario
    public List<Pedido> getPedidosUsuario(int userId) {
        List<Pedido> pedidos = new ArrayList<>();
        if (colaUsuarios(userId)) {//si hay pedios del usuario en cola
            logger.info("Pedidos hecho por el usuario");
            for(Pedido o : this.servirPedidios) {
                if (o.getUserID() == userId)
                    pedidos.add(o);
            }
            logger.info("Los pedidos hecho son:");
            return pedidos;
        }
        else {
            logger.warning("No hay hecho pedidos ");
            return pedidos;
        }
    }
    //lista de productos servidos ordenados por venta
    public List<Producto> getProductoVentas() {
        if (!servirPedidios.isEmpty()) {//si hay pedidios servidos
            logger.info("Los productos son:");
            return ProductosPorVenta(getPedidosServidos());
        }
        else {
            logger.warning("No has productos vendidos");
            return null;
        }

    }

    //Funciones secundarias (Privadas)
    //Me ordena los productos por Coste
    private List<Producto> ProductosPorCoste(List<Producto> producto) {
        producto.sort(Comparator.comparing(Producto::getPrecio));
        return producto;
    }
    //me dice si mi Usuario ha hecho pedidos o no
    private boolean colaUsuarios (int userId) {
        for(Pedido p : servirPedidios) {
            if(p.getUserID() == userId)
                return true;
        }
        return false;
    }
    //me ordena los productos por ventas
    private List<Producto> ProductosPorVenta(List<Producto> producto) {
        int bocadillo = 0;
        int refresco = 0;
        List<Producto> pro = new ArrayList<>();
        for (Producto p : producto) {//recorro la lista de productos para contar el numero de vetas( se puede hacer una variable global mas sencillo)
            switch(p.getProducto()) {
                case "Bocadillo":
                    bocadillo =+ p.getCantidad();
                    break;
                case "Refresco":
                    refresco =+ p.getCantidad();
                    break;
            }
        }
        int result = Integer.compare(bocadillo, refresco);
        if (result == 0) { //el mismo numero de ventas
            for (Producto p : producto) {
                if(!(pro.contains(p)))
                    pro.add(p);
            }
        }
        if (result < 0) { //HAY MAS REFRESCOS
            for (Producto p : producto) {
                if(!(pro.contains(p)) && p.getProducto() =="Refresco")
                    pro.add(p);
            }
            for (Producto p : producto) {
                if(!(pro.contains(p)) && p.getProducto() =="Bocadillo")
                    pro.add(p);
            }
        }
        if (result > 0) { //HAY MAS BOCATAS
            for (Producto p : producto) {
                if(!(pro.contains(p)) && p.getProducto() =="Bocadillo")
                    pro.add(p);
            }
            for (Producto p : producto) {
                if(!(pro.contains(p)) && p.getProducto() =="Refresco")
                    pro.add(p);
            }
        }
        return pro;
    }
    //Lista con los pedidos servidos
    private List<Producto> getPedidosServidos() {
        List<Producto> producto = new ArrayList<>();
        if (!servirPedidios.isEmpty()) { //si hay pedidos servidos
            for(Pedido p : this.servirPedidios) {
                producto.addAll(p.getProducto());
            }
            return producto;
        }
        else {
            return producto;
        }

    }
    public Usuario login(Usuario u) {
        return u;
    }
}