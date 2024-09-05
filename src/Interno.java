public class Interno {

    // Tipo interno
    public enum TipoInterno {
        I1, I2
    } 

    // Atributos
    private TipoInterno tipo;

    // Constructor
    public Interno(Interno.TipoInterno tipo) {
        this.tipo = tipo;
    }

    // Getters y Setters
    public TipoInterno getTipo() {
        return tipo;
    }

    public void setTipo(TipoInterno tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Interno [tipo=" + tipo + "]";
    }

}
