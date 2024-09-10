public class Producto {

    // Tipo producto
    public enum TipoProducto {
        A, FIN_A, B, FIN_B
    } 

    // Atributos
    private TipoProducto tipo;

    // Constructor
    public Producto(Producto.TipoProducto tipo) {
        this.tipo = tipo;
    }

    // Getters y Setters
    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "" + tipo + "";
    }

}
