
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Test {//inicializo valores y invoco a los metodos para comprovar su forma de actuar
    ProductManagerImplemets pm = ProductManagerImplemets.getInstance();
//Inicilizo las variables
    private final static Logger logger = Logger.getLogger(String.valueOf(Test.class));
    //Creo ususarios
    private Usuario u1;
    private Usuario u2;
    //Creo productos y la lista de los productos
    private Producto p1;
    private Producto p2;
    private Producto p3;
    private Producto p4;
    private List<Producto> pro1;
    private List<Producto> pro2;
    //Creo pedido
    private Pedido ped1;
    private Pedido ped2;

    //Creo los metodos para probar las funciones que he creado

    @Before //Lo que se hace antes de empezar la demostracion
    //Primero inicilizo las estructuras de datos
    public void setUp() throws Exception {
        //Creo dos usuarios
        u1 = new Usuario(1,"Cilia");
        u2 = new Usuario (2,"Ines");
        //Creo dos podibles productos
        p1 = new Producto("Bocadillo",5,1);
        p2 = new Producto("Refresco",2,2);
        p3 = new Producto("Corasan",3,2);
        p4 = new Producto("Zumo",1,1);
        //lista de productos
        pro1 = new ArrayList<>();
        pro2 = new ArrayList<>();
        //Añado a cada lista un producto
        pro1.add(p1);
        pro1.add(p2);
        pro2.add(p3);
        pro2.add(p4);
        //Añado a la orden el producto el usuario que lo quiere
        ped1 = new Pedido(pro1, u1.getIdUser(),false);
        ped2 = new Pedido(pro2, u2.getIdUser(), false);
    }

    @After //Lo que hago al acabar la demostracion
    //pongo los parametros a null para evitar problemas si vuelvo a arrancar el Testp
    public void tearDown(){
        u1 = null;
        u2 = null;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
        pro1 = null;
        pro2 = null;
       pm.getPedidos().clear();
       pm.getServirPedidios().clear();
    }
    //test para realizar un pedido
    @org.junit.Test
    public void hacerPedido(){
        logger.info("Test: Realizar Pedido de " +u1.getUser() );
        Assert.assertTrue(pm.getInstance().hacerPedido(u1.getIdUser(), pro1));//si el boolean de respuesta es true
        }
    //test para sevir el pedido
    @org.junit.Test
    public void servirPedido(){
        logger.info("Test: Servir Pedido de " +u2.getUser());
        pm.getInstance().hacerPedido(u2.getIdUser(),pro2);
        pm.getInstance().servirPedido();
        Assert.assertEquals(0,pm.getInstance().getPedidos().size());//Me aseguro de que el pedido sea eliminado de la cola del pedidos servidos
    }

}
