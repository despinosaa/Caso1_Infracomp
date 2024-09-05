public class Productor {
    
    // Tipo productor
    public enum TipoProductor {
        A, B
    } 

    // Atributos
    private TipoProductor tipo;
    private int numProductos;

    // Constructor
    public Productor (TipoProductor tipo, int numProductos) {
        this.tipo = tipo;
        this.numProductos = numProductos;
    }

    // Getters y Setters
    public TipoProductor getTipo() {
        return tipo;
    }

    public void setTipo(TipoProductor tipo) {
        this.tipo = tipo;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    @Override
    public String toString() {
        return "Productor [tipo=" + tipo + ", numProductos=" + numProductos + "]";
    }
    

}
