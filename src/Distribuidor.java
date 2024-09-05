public class Distribuidor {
    
    // Tipo productor
    public enum TipoDistribuidor {
        A, B
    } 

    // Atributos
    private TipoDistribuidor tipo;

    // Constructor
    public Distribuidor(TipoDistribuidor tipo) {
        this.tipo = tipo;
    }
    
    // Getters y Setters
    public TipoDistribuidor getTipo() {
        return tipo;
    }

    public void setTipo(TipoDistribuidor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Distribuidor [tipo=" + tipo + "]";
    }
    
}
