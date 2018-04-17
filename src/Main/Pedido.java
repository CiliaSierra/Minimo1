
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    //El id que me relaciona el pedido con el ususario
    private int userId;
    //lista de producuto, precio y cantidad
    private List<Producto> producto;
    //boleano para saber si el pedido esta hecho o no
    private boolean servido;

    //contructor
    public Pedido (List<Producto> producto, int userId, boolean servido){
        this.producto = producto;
        this.userId = userId;
        this.servido = servido;
    }

    //una lista con los pedidos
    public Pedido (){
        this.producto  = new ArrayList<>();
    }
    //Getters y setters

    public int getUserID() {
        return userId;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public boolean isServido() {
        return servido;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public void setUserID(int userID) {
        this.userId = userID;
    }

    public void setServido(boolean servido) {
        this.servido = servido;
    }
}
