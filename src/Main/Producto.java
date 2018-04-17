public class Producto { //crear una extension con los diferentes productos
    //nombre
    private String producto;
    //precio
    private int precio;
    //cantidad
    private int cantidad;
    //contructor
    public Producto (String producto, int precio, int cantidad)
    {
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    //Getters y setters

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getProducto() {
        return producto;
    }
}
