public class Distribuidor {
    
    // Tipo productor
    public enum TipoDistribuidor {
        A, B
    } 

    // Atributos
    private TipoDistribuidor tipo;
    private DepositoDistribucion depDist;


    // Constructor
    public Distribuidor(TipoDistribuidor tipo, DepositoDistribucion depDist) {
        this.tipo = tipo;
        this.depDist = depDist;
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
